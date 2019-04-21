package cc3002.tarea1;

public abstract class AbstractAttack implements IAttack {
    private int baseDamage;
    private String name;
    private String description;

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     * @param description Text description of the attack
     */
    protected AbstractAttack(String name, int baseDamage, String description) {
        this.baseDamage = baseDamage;
        this.name = name;
        this.description = description;
    }

    //region Properties
    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
    //endregion

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IAttack && ((IAttack) obj).getBaseDamage() == baseDamage
                && ((IAttack) obj).getName().equals(name)
                && ((IAttack) obj).getDescription().equals(description);
    }
}
