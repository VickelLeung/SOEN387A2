/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.util.HashMap;
import javax.servlet.http.Part;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vicke
 */
public class repositoryCoreTest {
    
    public repositoryCoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class repositoryCore.
     */
    @org.junit.Test
    public void testGetInstance() {
        System.out.println("getInstance");
        repositoryCore expResult = null;
        repositoryCore result = repositoryCore.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllBooks method, of class repositoryCore.
     */
    @org.junit.Test
    public void testListAllBooks() throws Exception {
        System.out.println("listAllBooks");
        repositoryCore instance = null;
        String expResult = "";
        String result = instance.listAllBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookInfo method, of class repositoryCore.
     */
    @org.junit.Test
    public void testGetBookInfo_int() throws Exception {
        System.out.println("getBookInfo");
        int id = 0;
        repositoryCore instance = null;
        HashMap expResult = null;
        HashMap result = instance.getBookInfo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookInfo method, of class repositoryCore.
     */
    @org.junit.Test
    public void testGetBookInfo_String() throws Exception {
        System.out.println("getBookInfo");
        String isbn = "";
        repositoryCore instance = null;
        HashMap expResult = null;
        HashMap result = instance.getBookInfo(isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewBook method, of class repositoryCore.
     */
    @org.junit.Test
    public void testAddNewBook() throws Exception {
        System.out.println("addNewBook");
        Book bookInfo = null;
        repositoryCore instance = null;
        int expResult = 0;
        int result = instance.addNewBook(bookInfo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBookInfo method, of class repositoryCore.
     */
    @org.junit.Test
    public void testUpdateBookInfo() throws Exception {
        System.out.println("updateBookInfo");
        int id = 0;
        Book b = null;
        repositoryCore instance = null;
        instance.updateBookInfo(id, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class repositoryCore.
     */
    @org.junit.Test
    public void testSetImage() throws Exception {
        System.out.println("setImage");
        Part filePart = null;
        int id = 0;
        repositoryCore instance = null;
        instance.setImage(filePart, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBook method, of class repositoryCore.
     */
    @org.junit.Test
    public void testDeleteBook() throws Exception {
        System.out.println("deleteBook");
        int id = 0;
        repositoryCore instance = null;
        instance.deleteBook(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAllBooks method, of class repositoryCore.
     */
    @org.junit.Test
    public void testDeleteAllBooks() throws Exception {
        System.out.println("deleteAllBooks");
        repositoryCore instance = null;
        instance.deleteAllBooks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateId method, of class repositoryCore.
     */
    @org.junit.Test
    public void testGenerateId() throws Exception {
        System.out.println("generateId");
        repositoryCore instance = null;
        instance.generateId();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastId method, of class repositoryCore.
     */
    @org.junit.Test
    public void testGetLastId() throws Exception {
        System.out.println("getLastId");
        repositoryCore instance = null;
        int expResult = 0;
        int result = instance.getLastId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class repositoryCore.
     */
    @org.junit.Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        repositoryCore.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
