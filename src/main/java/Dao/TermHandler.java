/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.Term;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Line's laptop
 */
public class TermHandler extends DefaultHandler{
     List<Term> termList = new ArrayList<>();
    Term currentTerm = null;
    
    boolean isRollNo = false, isFullname = false, isGender = false, isAddress = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("student")) {
            currentTerm = new Term();
        } else if(qName.equalsIgnoreCase("rollNo")) {
            isRollNo = true;
        } else if(qName.equalsIgnoreCase("fullname")) {
            isFullname = true;
        } else if(qName.equalsIgnoreCase("gender")) {
            isGender = true;
        } else if(qName.equalsIgnoreCase("address")) {
            isAddress = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("student")) {
            studentList.add(currentTerm);
            currentTerm = null;
        } else if(qName.equalsIgnoreCase("rollNo")) {
            isRollNo = false;
        } else if(qName.equalsIgnoreCase("fullname")) {
            isFullname = false;
        } else if(qName.equalsIgnoreCase("gender")) {
            isGender = false;
        } else if(qName.equalsIgnoreCase("address")) {
            isAddress = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        
        if(isId) {
            currentTerm.setId(value);
        } else if(isDate) {
            currentTerm.setDate(value);
        } else if(isTitle) {
            currentTerm.setTitle(value);
        } else if(isPrice) {
            currentTerm.setPrice(value);
        }else if(isDescription) {
            currentTerm.setDescription(value);
        }
    }

    public List<Term> getTermList() {
        return termList;
    }
}
