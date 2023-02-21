package com.owls.owlworld.admin;

import com.owls.owlworld.admin.model.Major;
import com.owls.owlworld.admin.model.TableRow;
import com.owls.owlworld.admin.model.University;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminService {

    public void crawling() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/youngseo.kim/Downloads/chromedriver_mac_arm64/chromedriver");

        WebDriver driver = new ChromeDriver();

        String root = "https://www.adiga.kr/PageLinkAll.do?link=/kcue/ast/eip/eis/inf/selctninf/EipSelctnInfGnrl.do&p_menu_id=PG-EIP-06001";

        driver.get(root);

        Thread.sleep(1000);

        // 특성화 등을 졸업한 재직자 선택
        WebElement selectElement = driver.findElement(By.id("chk_selctnNm_17"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].click();", selectElement);

        // 검색버튼 클릭
        WebElement linkElement = driver.findElement(By.linkText("검색"));
        linkElement.click();

        Thread.sleep(3000);

        // 총 건수 가져오기
        WebElement spanUnivTotal = driver.findElement(By.id("totalCountUniv"));
        String totalUniv = spanUnivTotal.getText();

        System.out.println("totalUniv " + totalUniv);

        WebElement tbodyElement = driver.findElement(By.xpath("//*[@id=\"tbResult\"]"));

        List<WebElement> trElements = tbodyElement.findElements(By.tagName("tr"));

        List<University> universities = new ArrayList<>();

        String prevUnivName = null;
        String prevPeriod = null;
        List<TableRow> tableRow = new ArrayList<>();
        for (WebElement trElement : trElements) {

            List<WebElement> tdElements = trElement.findElements(By.tagName("td"));

            // 0번째는 대학교 이름
            boolean hasUnivName = tdElements.get(0).findElements(By.tagName("a")).size() != 0;
            String univName = hasUnivName ? tdElements.get(0).findElement(By.tagName("a")).getText() : null;

            if (StringUtils.hasText(univName)) {
                prevUnivName = univName;
            } else {
                univName = prevUnivName;
            }

            // 1번째는 모집시기
            String period = StringUtils.hasText(tdElements.get(1).getText()) ? tdElements.get(1).getText() : null;
            if (StringUtils.hasText(period)) {
                prevPeriod = period;
            } else {
                period = prevPeriod;
            }

            // 2번째는 학과
            String majorName = tdElements.get(2).findElement(By.tagName("a")).getText();
            // 3번째는 전형명
            String type = tdElements.get(3).findElement(By.tagName("a")).getText();
            // 4번째는 모집인원
            String total = tdElements.get(4).getText();
            // 5번째는 경쟁률
            String competitive = tdElements.get(5).getText();

            TableRow row = new TableRow(univName, period, majorName, type, total, competitive);

            System.out.println(row);
        }
    }
}