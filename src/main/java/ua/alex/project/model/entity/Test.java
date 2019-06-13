package ua.alex.project.model.entity;

public class Test {

    private long id;
    private String name;
    private String theme;
    private int questNumber;
    private int needAnswerNumber;

    public Test() {

    }

    public Test(long id, String name, String theme, int questNumber, int needAnswerNumber) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.questNumber = questNumber;
        this.needAnswerNumber = needAnswerNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getQuestNumber() {
        return questNumber;
    }

    public void setQuestNumber(int questNumber) {
        this.questNumber = questNumber;
    }

    public int getNeedAnswerNumber() {
        return needAnswerNumber;
    }

    public void setNeedAnswerNumber(int needAnswerNumber) {
        this.needAnswerNumber = needAnswerNumber;
    }

    public static class Builder {
        private Test test;

        public Builder() {
            test = new Test();
        }

        public Builder setId(long id){
            test.id = id;
            return this;
        }

        public Builder setName(String name){
            test.name = name;
            return this;
        }

        public Builder setTheme(String theme){
            test.theme = theme;
            return this;
        }

        public Builder setQuestNumber(int questNumber){
            test.questNumber = questNumber;
            return this;
        }

        public Builder setNeedAnswerNumber(int needAnswerNumber){
            test.needAnswerNumber = needAnswerNumber;
            return this;
        }

        public Test build(){
            return test;
        }

    }



    @Override
    public String toString() {
        return "PassedTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", questNumber=" + questNumber +
                ", needAnswerNumber=" + needAnswerNumber +
                '}';
    }
}
