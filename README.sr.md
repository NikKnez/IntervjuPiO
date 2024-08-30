# IntervjuPiO

Dobrodošli u projekat IntervjuPiO! Ovaj projekat je veb aplikacija koja služi za učenje intervjua kroz preuzimanje dokumenata u docx formatu.

## Sadržaj

- [Opis](#opis)
- [Tehnologije](#tehnologije)
- [Instalacija](#instalacija)
- [Pokretanje aplikacije](#pokretanje-aplikacije)
- [Korišćenje](#korišćenje)
- [Doprinosi](#doprinosi)

## Opis

IntervjuPiO je aplikacija koja omogućava pregled i preuzimanje dokumenata sa pitanjima i odgovorima za intervjue. Aplikacija se sastoji od Spring Boot backend-a, React frontend-a i MongoDB baze podataka.

## Tehnologije

- [Spring Boot](https://spring.io/projects/spring-boot): Backend okvir za Java aplikacije.
- [React](https://reactjs.org/): Biblioteka za izradu interaktivnih veb aplikacija.
- [MongoDB](https://www.mongodb.com/): NoSQL baza podataka za skladištenje dokumenata.

## Instalacija

Da biste instalirali projekat, pratite sledeće korake:

1. **Klonirajte repozitorijum:**
    ```bash
    git clone https://github.com/NikKnez/intervjupio.git
    ```

2. **Pređite u direktorijum projekta:**
    ```bash
    cd intervjupio
    ```

3. **Instalirajte zavisnosti:**
    - Za backend:
        ```bash
        cd backend
        mvn clean install
        ```
    - Za frontend:
        ```bash
        cd frontend
        npm install
        ```

4. **Konfigurišite MongoDB:**
    - Podesite MongoDB bazu podataka koristeći MongoDB Atlas ili drugu uslugu.
    - Promenite `application.properties` u direktorijumu `backend` sa podacima o vašoj bazi podataka.

## Pokretanje aplikacije

Nakon što ste instalirali aplikaciju, možete je pokrenuti:

- **Pokrenite backend:**
    ```bash
    cd backend
    mvn spring-boot:run
    ```

- **Pokrenite frontend:**
    ```bash
    cd frontend
    npm start
    ```

Nakon ovih koraka, aplikacija će biti dostupna na [http://localhost:3000](http://localhost:3000).

## Korišćenje

- Aplikacija prikazuje listu dostupnih dokumenata.
- Klikom na dokument možete ga preuzeti u docx formatu.

## Uživo Demo

[Pogledajte uživo demo](https://intervjupio.netlify.app) IntervjuPiO.

## Doprinosi

Pozivam vas da doprinesete ovom projektu! Molimo vas da fork-ujete repozitorijum i kreirate pull request za bilo kakva poboljšanja ili ispravke grešaka.

**Razvio [NikKnez](https://github.com/NikKnez)**
