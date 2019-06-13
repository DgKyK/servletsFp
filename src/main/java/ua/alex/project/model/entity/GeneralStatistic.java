package ua.alex.project.model.entity;


import ua.alex.project.model.enums.Activity;

public class GeneralStatistic {

    private String login;
    private int tests;
    private int passed;
    private int failed;
    private Activity activity;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public static class Builder {

        private GeneralStatistic generalStatistic;

        public Builder() {
            generalStatistic = new GeneralStatistic();
        }

        public Builder setLogin(String login){
            generalStatistic.login = login;
            return this;
        }

        public Builder setTests(int tests){
            generalStatistic.tests = tests;
            return this;
        }

        public Builder setPassed(int passed){
            generalStatistic.passed = passed;
            return this;
        }

        public Builder setFailed(int failed){
            generalStatistic.failed = failed;
            return this;
        }

        public Builder setActivity(Activity activity){
            generalStatistic.activity = activity;
            return this;
        }

        public GeneralStatistic build(){
            return generalStatistic;
        }
    }


}
