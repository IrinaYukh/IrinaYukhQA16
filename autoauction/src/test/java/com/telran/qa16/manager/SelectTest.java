package com.telran.qa16.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectTest extends HelperBase {

    public Select select;

    public SelectTest(WebDriver wd)
    {
        super(wd);
    }
        public Select getSelect(WebElement element) {
            select = new Select(element);
            return select;
        }
}
