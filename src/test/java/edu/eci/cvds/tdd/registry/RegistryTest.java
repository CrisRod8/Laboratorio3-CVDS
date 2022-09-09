package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("Cristian",12345,21,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateDuplicate() {

        Person person = new Person("Cristian",12345,21,Gender.MALE,true);

        RegisterResult result1 = registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateIsDead() {

        Person person = new Person("Jose",43211,60,Gender.MALE,false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateUnderAge() {

        Person person = new Person("Santiago",45658,12,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateInvalidAge() {

        Person person = new Person("Ivan",78471,-2,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }


}