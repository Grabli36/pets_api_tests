package info.esoft.test.api.constants;

public class ConstAllure {

    public static class Epic {
        public static final String
                ADD_PETS  = "Добавить питомца",
                FIND_PETS = "Поиск питомца";
    }

    public static class Feature {
        public static final String
                POSITIVE = "Позитивные тесты",
                NEGATIVE = "Негативные тесты";
    }

    public static class Tag {
        public static final String
                ADD_PETS_POSITIVE  = "AddPetsPositive",
                FIND_PETS_POSITIVE = "FindPetsPositive";

        public static final String
                NEGATIVE = "negative",
                POSITIVE = "positive";
    }

    public static class Method {
        public static final String
                GET    = "GET ",
                POST   = "POST ",
                PUT    = "PUT ",
                DELETE = "DELETE ";
    }

    public static class StatusCode {
        static final String CODE = "CODE -";

        public static final String
                CODE_200 = " " + CODE + " 200",
                CODE_201 = " " + CODE + " 201",
                CODE_400 = " " + CODE + " 400",
                CODE_401 = " " + CODE + " 401",
                CODE_403 = " " + CODE + " 403",
                CODE_404 = " " + CODE + " 404",
                CODE_422 = " " + CODE + " 422";
    }

}
