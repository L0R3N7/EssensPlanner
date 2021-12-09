## Voraussichliche Technologien 
- UI (JavaFx)
- Communication App to Server (API, Quarkus, Java EE)
- Datenbank (JPA, Postgress)


## Geplannte Features
- Login Sign in (Java Fx)
- Password ändern (Java FX)
- Api (Quarkus, Java EE)
- Datenbank verbindung (JPA)
### Log in, Sign in
### Password ändern bzw vergessen
### Rezepte Suchen 
mit Tags (Vegan, Vegitarisch, Gesundheit, Raiting)
### Essen Planen in Monatansicht - Drag and drop

## Datenbank
### Tabelle
- User
    - Id (PK)
    - Email - Adres
    - Password (salted + hashed)
- Rezepte
    - Id (PK)
    - Bewertung (FK)
- Bewertung
    - Id (PK)
    - 1
    - 2
    - 3
    - 4
    - 5
- Tags
    - RezepteID (FK)
    - Eigenschaft
- Favorit Rezepts
    - UserId (FK, PK)
    - RezepteId (FK, PK)
- Geplanntes Essen 
    - Rezept (FK, PK)
    - Day (PK) 
    - Id  (PK)

## UI
### Seiten 
- login sign in 
- passwort vergessen
- rezepte suchen 
- zutatensuchen
- rezepte 
- zutaten
- rezepte plannen 





Login, Sign In
Rezepte Suchen
Rezept Anzeigen
Zutaten Anzeigen
Essensplan
Einkaufsliste