package interfaces;

import java.util.List;

import entities.TypeEntity;

public interface IType {
    public void addType(TypeEntity t);

    public List<TypeEntity> getType();
    
    public TypeEntity getTypeByName(String name);

    public void deleteType(int id);
}