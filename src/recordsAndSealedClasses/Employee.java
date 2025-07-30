package recordsAndSealedClasses;

/*
Immutable Data Carriers with Records
Less boilerplate: Records eliminate the need to manually write constructors,
equals(), hashCode(), toString(), and accessors—this is auto-generated based on defined components
Built-in immutability: Every record is immutable by default, making them thread-safe and
simpler to reason about
 */
public record Employee(int id, String name, String dept) {
}
