# BonussystemTDD

Bonussystem für Mitarbeiter auf Basis des **Decorator-Patterns**.

## Bonusberechnung
- **Seniority-Bonus:** +100€ alle 5 Jahre
- **Project-Completion-Bonus:** +10€ pro Projekt
- **Teamleader-Bonus:** +300€
- **Low-Absence-Bonus:** +300€ (≤10 Fehltage), +100€ (11–20 Fehltage)
- **High-Absence-Penalty:** -100€ (≥30 Fehltage), -300€ (≥40 Fehltage)
- **Performance-Multiplikator:** 1.0 (≤30 Punkte), 1.2 (≤70 Punkte), 1.5 (>70 Punkte)
- **BonusService:** Begrenzt den Bonus auf einen Mindest- und Höchstbetrag
