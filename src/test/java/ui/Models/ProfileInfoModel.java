package ui.Models;

public class ProfileInfoModel {

        private String title;
        private String firstName;
        private String lastName;
        private String homePhone;
        private String mobilPhone;
        private String workPhone;
        private String address;
        private String postalCode;
        private String region;
        private String locality;
        private String country;

        public ProfileInfoModel(String title, String firstName, String lastName, String homePhone, String mobilPhone, String workPhone, String address, String postalCode, String region, String locality, String country) {
            this.title = title;
            this.firstName = firstName;
            this.lastName = lastName;
            this.homePhone = homePhone;
            this.mobilPhone = mobilPhone;
            this.workPhone = workPhone;
            this.address = address;
            this.postalCode = postalCode;
            this.region = region;
            this.locality = locality;
            this.country = country;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getHomePhone() {
            return homePhone;
        }

        public void setHomePhone(String homePhone) {
            this.homePhone = homePhone;
        }

        public String getMobilPhone() {
            return mobilPhone;
        }

        public void setMobilPhone(String mobilPhone) {
            this.mobilPhone = mobilPhone;
        }

        public String getWorkPhone() {
            return workPhone;
        }

        public void setWorkPhone(String workPhone) {
            this.workPhone = workPhone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }


