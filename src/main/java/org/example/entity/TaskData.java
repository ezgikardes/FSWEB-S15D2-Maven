package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String task){
        switch (task){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);
            default:
                return new HashSet<>(); // Geçersiz bir task adı verilirse boş bir set döndür
        }
    }

    // varargs (variable arguments) metodu birden fazla parametre alabilir hale getirir
    // belirtilen türde bir veya birden fazla argümanın alınmasına olanak tanır.
    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... sets){
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : sets){
            unionSet.addAll(set);
        }
        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2){
        Set<Task> commonTasks = new HashSet<>(set1);
        commonTasks.retainAll(set2);
        return commonTasks;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2){
        Set<Task> tasksCopy = new HashSet<>(set1);
        tasksCopy.removeAll(set2);
        return tasksCopy;
    }



}
