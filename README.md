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
* Maven 3.9.6


## 4. Biblioteki

* JavaFX
* sqlite-jdbc 3.45.3.0

## 5. Instalacja i uruchomienie

Aby zainstalować i uruchomić aplikację należy zrealizować następujące kroki:
1. Pobrać i zainstalować Git https://git-scm.com/downloads.
   Po instalacji należy ustawić dwie zmienne środowiskowe PATH tak, aby wskazywały na miejsce instalacji git z folderem bin oraz z folderem cmd.
   Uruchomienie z terminala polecenia "git --version" powinno zwrócić wersję Git-a.
2. Pobrać i zainstalować Java oraz JDK (21+) https://www.oracle.com/pl/java/technologies/downloads/.
   Po instalacji należy ustawić zmienną środowiskową PATH tak, aby wskazywała na miejsce instalacji jdk z folderem bin oraz JAVA_HOME na miejsce instalacji jdk.
   Uruchomienie z terminala polecenia "java --version" powinno zwrócić wersję Jav-y.
3. Pobrać i zainstalować Maven w wersji 3.9.6 https://maven.apache.org/docs/3.9.6/release-notes.html.
   Podobnie jak przy JDK również tutaj należy skonfigurować zmienną środowiskową PATH, aby wskazywała na miejsce instalacji maven z folderem bin.
   Uruchomienie z terminala polecenia "mvn --version" powinno zwrócić wersję Maven.
4. W terminalu użyć polecenia "git clone git@github.com:NABrainn/BookManagementApp.git", a następnie przenieść się do sklonowanego repozytorium.
5. Poleceniem "mvn clean javafx:run" uruchomić aplikację.

**Realizacja punktów 1. - 3. będzie wyglądać inaczej na różnych systemach operacyjnych. W powyższej instrukcji została opisany proces instalacji w systemie Windows 11.