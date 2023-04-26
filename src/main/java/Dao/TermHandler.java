/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.Term;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author Line's laptop
 */
public class TermHandler extends DefaultHandler{
    List<Term> termList = new ArrayList<>();
    Term currentTerm = null;
    
    boolean isId = false, isDate = false, isTitle = false, isPrice = false, isDescription, isType;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("term")) {
            currentTerm = new Term();
        } else if(qName.equalsIgnoreCase("id")) {
            isId = true;
        } else if(qName.equalsIgnoreCase("date")) {
            isDate = true;
        } else if(qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if(qName.equalsIgnoreCase("price")) {
            isPrice = true;
        }
        else if(qName.equalsIgnoreCase("description")) {
            isDescription = true;
        }
        else if(qName.equalsIgnoreCase("type")) {
            isType = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("term")) {
            termList.add(currentTerm);
            currentTerm = null;
        } else if(qName.equalsIgnoreCase("id")) {
            isId = false;
        } else if(qName.equalsIgnoreCase("date")) {
            isDate = false;
        } else if(qName.equalsIgnoreCase("title")) {
            isTitle = false;
        } else if(qName.equalsIgnoreCase("price")) {
            isPrice = false;
        }else if(qName.equalsIgnoreCase("description")) {
            isDescription = false;
        }else if(qName.equalsIgnoreCase("type")) {
            isType = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        
        if(isId) {
            currentTerm.setId(Integer.parseInt(value));
        } else if(isDate) {
            currentTerm.setDate(LocalDate.parse(value));
        } else if(isTitle) {
            currentTerm.setTitle(value);
        } else if(isPrice) {
            currentTerm.setPrice(Integer.parseInt(value));
        }else if(isDescription) {
            currentTerm.setDescription(value);
        }else if(isType) {
            currentTerm.setType(value);
        }
    }

    public List<Term> getTermList() {
        return termList;
    }
}
