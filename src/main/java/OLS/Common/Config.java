package OLS.Common;

import org.openqa.selenium.By;

public class Config
{
/**
* Назва авторизаційного кукі
*/
public static final String KEY_NAME_OF_AUTH_COOKIE="__AUTH_COOKIE_OLS";


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
* Визначення типу субєкта організації, ключі якої використовуються в тестах
* 1 - Юридична особа
* 2 - Фізична особа
* 3 - Фізична особа підриємець
*/
public static final int ORG_SUBJECT_TYPE_FOR_REQEST=1;



/**
* Дані про ключ та сертифікат користувача, контекст якого викорисовується при авторизації
*/
public static final String PSSS_TO_KEY="1qaz2wsx";
//public static final String WAY_TO_PASS="C:\\Users\\oleks\\OneDrive\\Документи\\Tools_setup\\IDEA_Projects\\OlsAutoTest2025\\src\\main\\resources\\TEST_KEY\\Key-6.dat";
public static final String WAY_TO_PASS="C:\\Users\\o_klochenko\\Documents\\test\\KEYS _test\\Для тестового КНЕДП\\ДСНС\\Для ДСНС_2024_2025\\ТОВ Дванадцять\\Директор Іван Васильович\\Key-6.dat";
public static final String TEST_ORG_NAME="ТОВ \"Дванадцять\"";
public static final String TEST_ORG_EDRPOU="22443355";



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

/**
* Вибір ліцензії для замовлення (ЮО)
* 1 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» для юридичних осіб «Індивідуальна - Базова» «Звітність» на 1 рік
* 2 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» «Звітність з акцизного податку» для юридичних осіб на 1 рік
* 3 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» «Облік з ПДВ» для юридичних осіб на 1 рік
* 4 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» «Банківська звітність» на 1 рік
* 5 - Ліцензія комп'ютерної програми «Арт-Звіт Pro» «Модуль звітність до НБУ» на 1 рік
* 6 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» «Модуль РРО» на 1 рік
* 7 - Ліцензія комп'ютерної програми "Арт-Звіт Pro" "Термінальна" для юридичних осіб на 1 рік
*
* Вибір ліцензії для замовлення (ФОП/ФО/ЮО)
*  8 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» «Модуль первинних документів» на 1 рік
*  9 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» – «Транзакції первинних документів» (1 транзакція)
*  10 - Ліцензія сервіса «Арт-Офіс» «Модуль 1С-Арт-Офіс»
*  11 - Ліцензія на сервіс «Мій Арт-Офіс. Модуль Віджет».(50 документів включно)
*  12 - Створення та підписання документів в рамках Ліцензії на сервіс "Мій Арт - Офіс. Віджет" та/або "Мій Арт - Офіс" (1 транзакція)
*  13 - Ліцензія на сервіс «Мій Арт-Офіс» «Конектор до системи ЕДО "Вчасно»
*  14 - Програмний продукт Ліцензія "Арт-Крипто+" Базова на 1 рік
*  15 - Програмний продукт Ліцензія "Арт-Крипто+" Пакетний підпис на 1 рік
*
* Вибір ліцензії для замовлення (ФОП/ФО)
* 16 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» для ФОП «Індивідуальна - Базова» на 1 рік
* 17 - Ліцензія КП "Арт-Звіт Лайт" для ФОП без найманих працівників на 1 рік
* 18 - Право на перехід на ліцензію комп’ютерної програми «Арт-Звіт Pro» для ФОП «Індивідуальна - Базова» строк дії якої закінчується одночасно з закінченням строку дії раніше придбаної Ліцензії “Арт-Звіт Лайт”
* 19 - Ліцензія комп’ютерної програми «Арт-Звіт Pro» «Модуль РРО» на 1 рік
* 20 - Ліцензія комп'ютерної програми "Арт-Звіт Pro" "Термінальна" для ФОП на 1 рік
*/
public static final int LICENSE_ID_USING_IN_REQEST=9;
public static final String PRICE_OF_CHOOSEN_LICENSE="270.00";

/**
* Дані про замовлення в якому є потреба визначення кількості транзакцій
*/
public static final int COUNT_FOR_TRNSACTIONS_IN_REQEST=100;
public static final double COST_ONE_TRANSACTION_IN_MAO=5.40;
public static final double COST_ONE_TRANSACTION_IN_AZ=2.70;

/**
* Додаткові налаштування
*/
public static final int[]   LICENSE_IDS_FOR_YO_ONLY=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
public static final int[]   LICENSE_IDS_FOR_FOP_FO_ONLY=new int[]{16,17,18,19,20,8,9,10,11,12,13,14,15};


}
