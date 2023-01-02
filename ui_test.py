import unittest

from pwdriver import core
from selenium import webdriver

from test.page.login_page import LoginPage

id, pw = 'wrong_id', 'wrong_pw'


class LoginTest(unittest.TestCase):
    def setUp(self) -> None:
        core.setup_chromedriver()
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()

    def tearDown(self) -> None:
        self.driver.quit()

    def test_01(self) -> None:
        page = LoginPage(self.driver)
        page.get()
        page.login(f'{id}', f'{pw}')
        self.assertIn('https://nid.naver.com/nidlogin.login', self.driver.current_url)


if __name__ == '__main__':
    unittest.main()

