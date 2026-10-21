package workbook;

class TestDataGenerator {
    /**
     * @deprecated Folosiți {@link #generateUserSecure()} în schimb. Această metodă folosește parole nesigure.
     */
    @Deprecated
    public String generateUserLegacy() {
        return "user_admin / password123";
    }

    public String generateUserSecure() {
        return "user_admin / Token_XZY987";
    }
}