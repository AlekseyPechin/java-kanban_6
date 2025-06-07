package main.model;

import main.taskStatusAndType.Status;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Integer> idSubtasks = new ArrayList<>();

    public Epic(String name, String description, Status status) {
        super(name, description, status);
    }

    public Epic(String name, String description) {
        super(name, description);
    }

    public Epic(String name, String description, Integer id) { // Конструктор для обновления: наименования и описания
        super(name, description, id);
        this.status = Status.NEW;
    }

    public ArrayList<Integer> getIdSubtasks() {
        return idSubtasks;
    }

    public void setIdSubtasks(ArrayList<Integer> idSubtasks) {
        this.idSubtasks = idSubtasks;
    }

    public void clearIdSubtaskArrays() {
        idSubtasks.clear();
    }

    public void addIdSubtask(int idSubtask) {
        idSubtasks.add(idSubtask);
    }

    public void removeSubtaskById(int idSubtask) {
        idSubtasks.removeIf(subtask -> subtask == idSubtask);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ". name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", status=" + getStatus() + ", подзадачи: " + getIdSubtasks() + " \n";
    }
}