package recordsAndSealedClasses;

/*
The sealed interface (DomainEvent) explicitly restricts which implementations are allowed—only
UserCreated, UserUpdated, and UserDeleted are permitted.

Attempting to add another subtype (like UserSuspended) is a breaking change and will
fail compilation—forcing you to make the change intentionally, with awareness
This helps ensure domain stability and supports exhaustive handling later in pattern
matching or switch expressions
 */
public sealed interface Vehicle permits Car, Bike{

    void start();
    void applyBrakes();
}
