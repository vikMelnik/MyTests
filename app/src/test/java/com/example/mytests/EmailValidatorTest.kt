package com.example.mytests

import org.junit.Assert.*
import org.junit.Test


class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }
    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }
    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }
    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }
    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        val validEmail = EmailValidator.isValidEmail("@email.com")
        assertFalse("NoUserName", validEmail)
    }
    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NotEqualsString_ReturnsFalse() {
        assertNotEquals("name@email.ru", "name@email.com")
    }

    //Negative test
    @Test
    fun emailValidator_EqualsString_ReturnsTrue() {
        assertEquals("name@email.com", "name@email.co")
    }

    //Negative test
    @Test
    fun emailValidator_NotNullString_ReturnsTrue(){
        assertNotNull("NotNull", null)
    }
    @Test
    fun emailValidator_NullString_ReturnsTrue(){
        assertNull("Null", null)
    }

    @Test
    fun emailValidator_SameString_ReturnsFalse(){
        assertSame("DomainName","name@", "name@")
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}

