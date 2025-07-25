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

    /**
     * Дані про ключ та сертифікат користувача, контекст якого викорисовується при авторизації
     */
    public static final String PSSS_TO_KEY="1qaz2wsx";
//    public static final String WAY_TO_PASS="C:\\Users\\oleks\\OneDrive\\Документи\\Tools_setup\\IDEA_Projects\\OlsAutoTest2025\\src\\main\\resources\\TEST_KEY\\Key-6.dat";
    public static final String WAY_TO_PASS="C:\\Users\\o_klochenko\\Documents\\test\\KEYS _test\\Для тестового КНЕДП\\ДСНС\\Для ДСНС_2024_2025\\ТОВ Дванадцять\\Директор Іван Васильович\\Key-6.dat";
    public static final String TEST_ORG_NAME="ТОВ \"Дванадцять\"";

/**
 * Вибір ідентифікатору потрібного КНЕДП
 * <option data-index-id="30">Адміністратор ІТС ЦЗО (CA TEST)</option>
 * <option data-index-id="0">КНЕДП ДПС України</option>
 * <option data-index-id="2">КНЕДП "MASTERKEY" ТОВ "АРТ-МАСТЕР"</option>
 * <option data-index-id="3">КНЕДП ТОВ "Центр сертифікації ключів "Україна"</option>
 * <option data-index-id="5">КНЕДП ПАТ КБ «ПРИВАТБАНК»</option>
 * <option data-index-id="6">КНЕДП "Дія"</option>
 * <option data-index-id="7">КНЕДП Публічного акціонерного товариства "УкрСиббанк"</option>
 * <option data-index-id="8">КНЕДП ринку електричної енергії</option>
 * <option data-index-id="9">КНЕДП Укрзалізниці</option>
 * <option data-index-id="10">КНЕДП АТ "Ощадбанк"</option>
 * <option data-index-id="11">КНЕДП ДП "УСС"</option>
 * <option data-index-id="12">КНЕДП ТОВ "ДЕПОЗИТ САЙН"</option>
 * <option data-index-id="14">КНЕДП Національного банку України</option>
 * <option data-index-id="15">Кваліфікований надавач ЕДП "Казначейство"</option>
 * <option data-index-id="16">КНЕДП АБ "УКРГАЗБАНК"</option>
 * <option data-index-id="17">КНЕДП АЦСК АТ "СЕНС-БАНК"</option>
 * <option data-index-id="18">КНЕДП Акціонерного товариства “КРЕДІ АГРІКОЛЬ БАНК”</option>
 * <option data-index-id="19">КНЕДП АТ "БАНК АЛЬЯНС"</option>
 * <option data-index-id="20">КНЕДП АТ "ПУМБ"</option>
 * <option data-index-id="21">КНЕДП "eSign" ТОВ "Ілайф"</option>
 * <option data-index-id="23">КНЕДП АТ "ПРАВЕКС БАНК"</option>
 * <option data-index-id="24">КНЕДП ТОВ "Вчасно Сервіс"</option>
 * <option data-index-id="25">КНЕДП ТОВ "АМО ФІНТЕХ"</option>
 * <option data-index-id="26">КНЕДП monobank | Universal Bank</option>
 * <option data-index-id="13">Інший КНЕДП</option>
 */
public static final int ID_OF_KNDP=30;

    public static final String KEY_NAME_OF_AUTH_COOKIE="__AUTH_COOKIE_OLS";


}
