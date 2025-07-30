package enums;

/*
Enums implicitly extend Enum, so they can't extend other classes.
Multiple inheritance isn't allowed, though interfaces can be implemented.
Abstract methods inside enums must be implemented by every constant or subclass via anonymous bodies.
For systems with ever-changing sets of values, enums may become rigid if not managed
 */
public enum Day {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}
