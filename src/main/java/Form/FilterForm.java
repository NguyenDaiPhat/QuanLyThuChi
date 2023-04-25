/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

/**
 *
 * @author Line's laptop
 */
public class FilterForm {
    private String typeSearch="";
    private String search="";
    private String typeFilter="";
    private String filter="";

    public FilterForm() {
    }

    public FilterForm(String typeSearch, String search, String typeFilter, String filter) {
        this.typeSearch = typeSearch;
        this.search = search;
        this.typeFilter = typeFilter;
        this.filter = filter;
    }

    public String getTypeSearch() {
        return typeSearch;
    }

    public void setTypeSearch(String typeSearch) {
        this.typeSearch = typeSearch;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getTypeFilter() {
        return typeFilter;
    }

    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    
}
