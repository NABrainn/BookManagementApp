## 1. Zarządzanie Książkami


### Spis treści

1. [Wstęp](#1-wstęp)
2. [Zaimplementowane funkcjonalności](#2-zaimplementowane-funkcjonalności)
3. [Wymagania](#3-wymagania)
4. [Biblioteki](#4-biblioteki)
5. [Instalacja i uruchomienie](#5-instalacja-i-uruchomienie)

## 1. Wstęp

Aplikacja "Zarządzanie książkami" umożliwia użytkownikowi stworzyć własną bazę książek oraz ją przeglądać w interfejsie graficznym.

## 2. Zaimplementowane funkcjonalności

* Wyświetlanie książek - książki są zczytywane z pliku "books.db", a następnie wyświetlane w tabeli.
* Dodawanie książek - po prawidłowym wypełnieniu wymaganych pól, kilknięcie przycisku "Add" dodaje książkę do bazy.
* Usuwanie książek - zaznaczona w tabeli książka zostaje usunięta po kliknięciu przycisku "Delete".
* Sortowanie książek - kliknięcie dowolnego nagłówka w tabeli sprawi, że widoczna baza książek zostanie przesortowana po wybranym polu.
* Wyszukiwanie książek - wpisanie tekstu w polu poniżej "Regex search" umożliwia wyświetlenie w tabeli tylko tych tytułów, które zgadzają się z wprowadzonym wyrażeniem regularnym.

## 3. Wymagania

* Java (JDK 21+)
* Git
* JavaFX SDK

## 4. Biblioteki

* JavaFX
* SQLite JDBC

## 5. Instalacja i uruchomienie

1. Pobrać i zainstalować Git https://git-scm.com/downloads.
   Uruchomienie z terminala polecenia "git --version" powinno zwrócić wersję Git-a.
2. Pobrać i zainstalować Java oraz JDK (21+) https://www.oracle.com/pl/java/technologies/downloads/.
   Uruchomienie z terminala polecenia "java --version" powinno zwrócić wersję Jav-y.
3. Pobrać JavaFX SDK 22.0.1 ze strony https://gluonhq.com/products/javafx/
4. W terminalu użyć polecenia "git clone `git@github.com:NABrainn/BookManagementApp.git`", a następnie przenieść się do sklonowanego repozytorium.
5. Poleceniem</br>
   * Linux/MacOS: "java --module-path /path/to/javafx-sdk-22.0.1/lib --add-modules javafx.controls,javafx.fxml -jar '/path/to/BookManagement.jar'"</br></br>
   * Windows: "java --module-path "\path\to\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar '\path\to\BookManagement.jar'" </br></br>
     uruchomić aplikację. Plik .jar znajduje się w strukturze 'out'.