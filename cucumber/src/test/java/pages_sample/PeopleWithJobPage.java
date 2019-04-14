package pages_sample;

import helpers.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

public class PeopleWithJobPage extends HelperBase {

    public PeopleWithJobPage(WebDriver wd) {
        super(wd);
    }

    public int listSize;

    public void clickOnDeleteButton(int position) {
        wd.findElement(By.xpath(String.format
        ("//*[@id=\"person%s\"]/span[1]", position))).click();
    }

    public int peopleListSize() {
        /**
         * page does not display real size of records. There is a bug!
         * size() is calulating +1 extra item
         *
         * */
        listSize = wd.findElements(By.className("w3-padding-16")).size() - 1;
        return listSize;
    }

    public void deleteLastRecord() {
        clickOnDeleteButton(listSize);
    }

    public void checkRecordsListSie(int refValue) {
        assertEquals(refValue, peopleListSize());
    }
}
