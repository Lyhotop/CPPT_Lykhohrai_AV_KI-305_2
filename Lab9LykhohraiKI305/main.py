
from MultifunctionDevice import MultifunctionDevice

if __name__ == '__main__':

    myPrinter = MultifunctionDevice("HP", 110, 2, 3)
    myPrinter.power_on()
    myPrinter.about_printer()
    myPrinter.file_name = str(input("Введіть назву файлу, який потрібно зісканувати: "))
    myPrinter.print_document(myPrinter.scanDocument())
    myPrinter.about_printer()
    myPrinter.add_paper()
    myPrinter.about_printer()

