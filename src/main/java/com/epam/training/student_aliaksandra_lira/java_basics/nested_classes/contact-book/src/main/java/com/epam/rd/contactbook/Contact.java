package com.epam.rd.contactbook;

import java.util.Arrays;
import java.util.Objects;

public class Contact {
    private String contactName;
    private int phoneNumbersLimit = 1;
    private int emailsLimit = 3;
    private int socialsLimit = 5;
    private ContactInfo[] contactInfos, phoneNumberInfos, emailInfos, socialInfos;

    public Contact(String contactName) {
        this.contactName = contactName;
        contactInfos = new ContactInfo[]{new NameContactInfo()};
        initializeInfos();
    }

    public void rename(String newName) {
        if (newName != null && !Objects.equals(newName, "")) contactName = newName;
    }

    public Email addEmail(String localPart, String domain) {
        emailsLimit--;
        if (isLimitExceeded(emailsLimit)) return null;

        Email email = new Email(localPart, domain);
        emailInfos = addElementToArray(emailInfos, email);

        return email;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        emailsLimit--;
        if (isLimitExceeded(emailsLimit)) return null;

        Email epamEmail = new Email(firstname, lastname) {
            @Override
            public String getTitle() {
                return "Epam Email";
            }

            @Override
            public String getValue() {
                return String.format("%s_%s@epam.com", firstname, lastname);
            }
        };

        emailInfos = addElementToArray(emailInfos, epamEmail);

        return epamEmail;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        phoneNumbersLimit--;
        if (isLimitExceeded(phoneNumbersLimit)) return null;

        ContactInfo phoneNumberInfo = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return String.format("+%s %s", code, number);
            }
        };

        phoneNumberInfos = addElementToArray(phoneNumberInfos, phoneNumberInfo);

        return phoneNumberInfo;
    }

    public Social addSocialMedia(String title, String id) {
        socialsLimit--;
        if (isLimitExceeded(socialsLimit)) return null;

        Social social = new Social(title, id);
        socialInfos = addElementToArray(socialInfos, social);

        return social;
    }

    public Social addTwitter(String twitterId) {
        return addSocialMedia("Twitter", twitterId);
    }

    public Social addInstagram(String instagramId) {
        return addSocialMedia("Instagram", instagramId);
    }

    public ContactInfo[] getInfo() {
        mergeArrays(phoneNumberInfos, emailInfos, socialInfos);

        ContactInfo[] resultArray = new ContactInfo[0];
        for (ContactInfo contactInfo : contactInfos) {
            if (contactInfo != null) {
                resultArray = addElementToArray(resultArray, contactInfo);
            }
        }
        return resultArray;
    }

    private boolean isLimitExceeded(int count) {
        return count < 0;
    }

    private void mergeArrays(ContactInfo[]... arraysToAdd) {
        for (ContactInfo[] arrayToAdd : arraysToAdd) {
            for (ContactInfo contactInfo : arrayToAdd) {
                contactInfos = addElementToArray(contactInfos, contactInfo);
            }
        }
        initializeInfos();
    }

    private ContactInfo[] addElementToArray(ContactInfo[] array, ContactInfo element) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = element;
        return array;
    }

    private void initializeInfos() {
        phoneNumberInfos = new ContactInfo[0];
        emailInfos = new ContactInfo[0];
        socialInfos = new ContactInfo[0];
    }

    public static class Email implements ContactInfo {
        private final String email;

        public Email(String localPart, String domain) {
            email = String.format("%s@%s", localPart, domain);
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return email;
        }
    }

    public static class Social implements ContactInfo {
        private final String title;
        private final String socialId;

        public Social(String title, String socialId) {
            this.title = title;
            this.socialId = socialId;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return socialId;
        }
    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }
}
