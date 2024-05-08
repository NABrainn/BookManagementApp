## 1. Zarządzanie Książkami


### Spis treści

1. Wstęp
2. Zaimplementowane funkcjonalności
3. Wymagania
4. Biblioteki
5. Uruchamianie aplikacji

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

Aby pomyślnie uruchomić aplikację należy zrealizować następujące kroki:
1. Pobrać i zainstalować Git https://git-scm.com/downloads. Uruchomienie z terminala polecenia "git --version" powinno zwrócić wersję Git-a.
2. Pobrać i zainstalować Java oraz JDK (21+) https://www.oracle.com/pl/java/technologies/downloads/. Uruchomienie z terminala polecenia "java --version" powinno zwrócić wersję Jav-y.
Jeżeli instalacja przebiegła pomyślnie, pozostało ustawić zmienną środowiskową JAVA_HOME tak, aby wskazywała na miejsce instalacji jdk.
3. Pobrać i zainstalować Maven w wersji 3.9.6 https://maven.apache.org/docs/3.9.6/release-notes.html. Uruchomienie z terminala polecenia "mvn --version" powinno zwrócić wersję Maven.
Podobnie jak przy JDK również tutaj należy skonfigurować zmienną środowiskową - MAVEN_HOME, aby wskazywała na miejsce instalacji maven.
4. W terminalu przenieść się do katalogu wyboru, a następnie użyć polecenia "git clone git@github.com:NABrainn/BookManagementApp.git".
5. Poleceniem "mvn clean javafx:run" uruchomić aplikację.