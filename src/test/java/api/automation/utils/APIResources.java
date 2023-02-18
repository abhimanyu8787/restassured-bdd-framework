package api.automation.utils;

public enum APIResources {
    
    ListUsersAPI("/api/users"),
    ListUsers200ResponseSchema("src\\test\\resources\\jsonschema\\ListUsers200ResponseSchema.json");
    
    private String resource;
    
    APIResources(String resource){
        this.resource = resource;
    }
    
    public String getResource() {
        return resource;
    }

}
