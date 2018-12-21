package interfaces;

import java.util.List;

import entities.OptionsEntity;

public interface IOption {
    public void addOption(OptionsEntity o);

    public List<OptionsEntity> getOption();
    
    public OptionsEntity getOptionByName(String name);

    public void deleteOption(int id);
}