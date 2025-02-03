package com.amazon.util;

public class Constants {

    // Home Page Locators
    public static final String TODAYS_DEALS_LINK = "Today's Deals";
    public static final String SEARCH_BOX = "twotabsearchtextbox";
    public static final String SEARCH_BUTTON = "nav-search-submit-button";
    public static final String CART_BUTTON = "nav-cart";
    public static final String ORDERS_BUTTON = "nav-orders";

    // **Checkout Page Locators**
    public static final String PROCEED_TO_CHECKOUT = "proceedToRetailCheckout";
    public static final String ADD_NEW_ADDRESS = "//a[contains(text(), 'Add a new delivery address')]";
    public static final String ADDRESS_FULL_NAME = "address-ui-widgets-enterAddressFullName";
    public static final String ADDRESS_PHONE = "address-ui-widgets-enterAddressPhoneNumber";
    public static final String ADDRESS_POSTAL_CODE = "address-ui-widgets-enterAddressPostalCode";
    public static final String ADDRESS_LINE1 = "address-ui-widgets-enterAddressLine1";
    public static final String ADDRESS_LINE2 = "address-ui-widgets-enterAddressLine2";
    public static final String ADDRESS_CITY = "address-ui-widgets-enterAddressCity";
    public static final String STATE_DROPDOWN = "address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId";
    public static final String USE_THIS_ADDRESS_BUTTON = "//span[contains(text(), 'Use this address')]";

    // Deals Page Locators
    public static final String THIRD_DEAL = ".GridItem-module__container_PW2gdkwTj1GQzdwJjejN:nth-of-type(3)";
    public static final String ADD_TO_CART_BUTTON = "(//input[@id='add-to-cart-button'])[2]";
    public static final String CLOSE_CART_POPUP = "attach-close_sideSheet-link";

    // Login Page Locators
    public static final String SIGN_IN_BUTTON = "nav-link-accountList";
    public static final String EMAIL_FIELD = "//input[@type='email' or @name='email']";
    public static final String CONTINUE_BUTTON = "//input[@type='submit' and @aria-labelledby='continue-announce']";
    public static final String PASSWORD_FIELD = "//input[@type='password' or @name='password']";
    public static final String SIGN_IN_SUBMIT_BUTTON = "signInSubmit";

    //Navigation Page Locators
    public static final String MENU = "nav-hamburger-menu";
    public static final String MOBILES_COMPUTERS = "Mobiles, Computers";

    //Orders Page Locators
    public static final String ORDERS_TAB = "nav-orders";
    public static final String TIME_FILTER_DROPDOWN = "time-filter";

    // Payment Page Locators
    public static final String CARD_OPTION = "//input[@value='SelectableAddCreditCard']";
    public static final String ADD_CARD_IMAGE = "apx-add-pm-trigger-common-image";
    public static final String CARD_NUMBER_INPUT = "pmts-account-Number";
    public static final String NICKNAME_INPUT = "//input[@name='ppw-accountHolderName']";
    public static final String MONTH_DROPDOWN = "//select[@name='ppw-expirationDate_month']";
    public static final String YEAR_DROPDOWN = "//select[@name='ppw-expirationDate_year']";
    public static final String SAVE_CARD_BUTTON = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']";

    // Search Results Page Locators
    public static final String GET_IT_BY_TOMORROW_CHECKBOX = "//span[contains(text(), 'Get It by Tomorrow')]";
    public static final String FIRST_ITEM_DELIVERY_DATE = "(//div[@class='a-row a-size-base a-color-secondary s-align-children-center'])[1]";
    public static final String PRODUCT_PRICES = "//span[@class='a-price']";


}
