package util;

import org.openqa.selenium.WebElement;

public class ElementObject  {

    public WebElement element;
    public String elementType;

    public ElementObject(WebElement element, String elementType)
    {
        this.element = element;
        this.elementType = elementType;
    }
}
