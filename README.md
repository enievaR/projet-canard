# Diagramme UML

Diagramme de classes UML:

```mermaid
classDiagram
    class Canard {
        <<abstract>>
        -String nom
        -int pointsDeVie
        -int pointsAttaque
        -TypeCanard type
        +attaquer(Canard autreCanard)
        +subirDegats(int degats)
        +boolean estKO()
        +activerCapaciteSpeciale()
    }

    class CanardEau {
        +activerCapaciteSpeciale(): void
    }

    class CanardFeu {
        +activerCapaciteSpeciale(): void
    }

    class CanardGlace {
        +activerCapaciteSpeciale(): void
    }

    class CanardVent {
        +activerCapaciteSpeciale(): void
    }

    class TypeCanard {
        <<enum>>
        +EAU
        +FEU
        +GLACE
        +VENT
        +getMultiplicateur(TypeCanard attaquant, TypeCanard cible): double
    }

    class Combat {
        +Canard canard1
        +Canard canard2
        +void demarrerCombat()
    }

    class Main {
        +main(String[] args)
    }

    class CapaciteSpeciale {
        <<interface>>
        +activerCapaciteSpeciale(): void
    }

    class Statut {
        <<enum>>
        +String nom
        +String effet
        +int duree
        +void appliquerEffet(Canard cible)
    }

    Canard <|-- CanardEau
    Canard <|-- CanardFeu
    Canard <|-- CanardGlace
    Canard <|-- CanardVent
    Canard o-- TypeCanard
    Combat o-- Canard
    Main o-- Combat
    Canard o-- Statut
    Canard ..|> CapaciteSpeciale
    Canard ..|> Combattant
```

## Explication Diagramme
- `Main` est la classe principale qui contient la méthode `main` pour démarrer le programme.

- `Combat` est une classe qui gère le combat entre deux canards (boucle de jeu).

- `Canard` est une classe abstraite qui définit les propriétés et méthodes communes à tous les canards.

- `CanardEau`, `CanardFeu`, `CanardGlace` et `CanardVent` sont des sous-classes de `Canard` qui implémentent les capacités spéciales pour chaque type de canard.

- `TypeCanard` est une énumération qui définit les différents types de canards et fournit une méthode pour obtenir le multiplicateur de dégâts entre deux types de canards.	

- `CapaciteSpeciale` est une interface qui définit la méthode `activerCapaciteSpeciale` pour les capacités spéciales des canards.	

- `Statut` est une classe qui stocke l'effet appliqué et sa durée, et fournit une méthode pour appliquer l'effet à un canard.

- `Combattant` est une interface qui définit les méthodes `attaquer`, `subirDegats` et `estKO` pour les combattants.



## Explication et Réponses aux questions

### 1. Classes abstraites
- `Canard` pourrait être abstraite, car elle définit les propriétés et comportements communs aux différentes sous-classes.

### 2. Interfaces
- `CapaciteSpeciale` pour gérer les capacités spéciales.

### 3. Gestion des statuts (brûlé, paralysé...)
- Une classe `Statut` stocke l’effet appliqué et sa durée.
- Chaque canard a une liste de statuts actifs, mise à jour à chaque tour.

### 4. Avantages des classes/interfaces supplémentaires
- Facilite l’ajout de nouvelles capacités sans modifier les classes existantes.
- Standardise les comportements pour éviter la duplication du code.

### 5. Défis d’extensibilité
- Gestion des interactions entre types.
- Complexité accrue avec plus de capacités et de types.