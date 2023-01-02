from selenium.webdriver.common.by import By

from pwdriver.page import BasePage


class LoginPage(BasePage):
    def __init__(self, driver):
        super().__init__(driver)
        self._url = 'https://nid.naver.com/nidlogin.login'
        self._locator = {
            'id': (By.CSS_SELECTOR, 'input#id'),
            'pw': (By.CSS_SELECTOR, 'input#pw'),
            'login': (By.CSS_SELECTOR, 'button[id=\'log.login\']')
        }

    def login(self, id: str, pw: str) -> BasePage:
        self._by('id').send_keys(id)
        self._by('pw').send_keys(pw)
        self._by('login').click()
        return BasePage
