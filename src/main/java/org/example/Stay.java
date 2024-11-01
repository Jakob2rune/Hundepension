package org.example;



    public class Stay {
        private int stayID;
        private int dogID;
        private String startDate;
        private String endDate;
        private int amountOfStayDays;
        private int foodFrequencyPerDay;
        private int foodID;
        private int foodStartAmountGram;
        private int walkFrequencyPerDay;
        private int startKmPerDay;

        public Stay ()
        {}
        public Stay(int stayID, int dogID, String startDate, String endDate, int amountOfStayDays,
                    int foodFrequencyPerDay, int foodID, int foodStartAmountGram,
                    int walkFrequencyPerDay, int startKmPerDay) {
            this.stayID = stayID;
            this.dogID = dogID;
            this.startDate = startDate;
            this.endDate = endDate;
            this.amountOfStayDays = amountOfStayDays;
            this.foodFrequencyPerDay = foodFrequencyPerDay;
            this.foodID = foodID;
            this.foodStartAmountGram = foodStartAmountGram;
            this.walkFrequencyPerDay = walkFrequencyPerDay;
            this.startKmPerDay = startKmPerDay;
        }


        public int getStayID() {
            return stayID;
        }

        public int getDogID() {
            return dogID;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public int getAmountOfStayDays() {
            return amountOfStayDays;
        }

        public int getFoodFrequencyPerDay() {
            return foodFrequencyPerDay;
        }

        public int getFoodID() {
            return foodID;
        }

        public int getFoodStartAmountGram() {
            return foodStartAmountGram;
        }

        public int getWalkFrequencyPerDay() {
            return walkFrequencyPerDay;
        }

        public int getStartKmPerDay() {
            return startKmPerDay;
        }


        public void setStayID(int stayID) {
            this.stayID = stayID;
        }

        public void setDogID(int dogID) {
            this.dogID = dogID;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public void setAmountOfStayDays(int amountOfStayDays) {
            this.amountOfStayDays = amountOfStayDays;
        }

        public void setFoodFrequencyPerDay(int foodFrequencyPerDay) {
            this.foodFrequencyPerDay = foodFrequencyPerDay;
        }

        public void setFoodID(int foodID) {
            this.foodID = foodID;
        }

        public void setFoodStartAmountGram(int foodStartAmountGram) {
            this.foodStartAmountGram = foodStartAmountGram;
        }

        public void setWalkFrequencyPerDay(int walkFrequencyPerDay) {
            this.walkFrequencyPerDay = walkFrequencyPerDay;
        }

        public void setStartKmPerDay(int startKmPerDay) {
            this.startKmPerDay = startKmPerDay;
        }
    }


