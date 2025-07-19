package OLS.Common;

public class Config
{
    /**
     *Вибір браузера для ініціалізації драйвера
     *     CHROME_DRIVER=1;
     *     MOZILLA_DRIVER=2;
     */
    protected static final int DRIVER_INDEX=1;

    /**
     *Змінюючи параметр MAIN_URL можна виконувати тести для тест/реліз та прод оточення
     */
    public static final String MAIN_URL="https://ols-test.am-soft.ua/ols.test/";

    /**
     * Закривати браузер після виконання всіх тестів
     */
    public static final boolean NEED_TO_CLOSE_BROWSER_AFTER_TEST=false;



}
