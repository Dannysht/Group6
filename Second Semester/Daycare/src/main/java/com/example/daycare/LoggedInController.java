package com.example.daycare;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable
{
    //todo add buttons to the panes;
    private static int counter = 0;
    private static String username;

    @FXML
    Button addButton;
    @FXML
    AnchorPane addPane;
    @FXML
    Button viewButton;
    @FXML
    AnchorPane viewPane;
    @FXML
    Button updateButton;
    @FXML
    AnchorPane updatePane;
    @FXML
    Button removeButton;
    @FXML
    AnchorPane removePane;
    @FXML
    ImageView image;
    @FXML
    Button backButton;
    @FXML
    Button addKidButton;
    @FXML
    Button addTeacherButton;
    @FXML
    Button addScheduleButton;
    @FXML
    Button updateKid;
    @FXML
    Button updateTeacher;
    @FXML
    Button updateSchedule;
    @FXML
    Button viewKid;
    @FXML
    Button viewTeacher;
    @FXML
    Button viewSchedule;
    @FXML
    Button removeKid;
    @FXML
    Button removeTeacher;
    @FXML
    Button removeSchedule;
    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField dateOfBirth;
    @FXML
    TextField parentPhone;
    @FXML
    TextField parentName;
    @FXML
    TextField parentSurname;
    @FXML
    TextField address;
    @FXML
    TextField group;
    @FXML
    RadioButton waitingList;
    @FXML
    ImageView childImage;
    @FXML
    TextField teacherName;
    @FXML
    TextField teacherSurname;
    @FXML
    TextField teacherPhone;
    @FXML
    TextField groupNumber;
    @FXML
    ImageView teachersImage;
    @FXML
    TextField teacherID;
    @FXML
    TextField workDay;
    @FXML
    TextField startHour;
    @FXML
    TextField endHour;
    @FXML
    TableView tableKid;
    @FXML
    TableView tableEmp;
    @FXML
    TableView tableSchedule;

    public static void setUsername(String newUsername)
    {
        username = newUsername;
    }

    private void resetButtons()
    {
        addButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
        viewButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
        updateButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
        removeButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
        addKidButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
        addScheduleButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
        addTeacherButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater( () -> image.requestFocus() );
        addKidButton.setVisible(false);
        addTeacherButton.setVisible(false);
        addScheduleButton.setVisible(false);
        updateKid.setVisible(false);
        updateTeacher.setVisible(false);
        updateSchedule.setVisible(false);
        viewKid.setVisible(false);
        viewTeacher.setVisible(false);
        viewSchedule.setVisible(false);
        removeKid.setVisible(false);
        removeTeacher.setVisible(false);
        removeSchedule.setVisible(false);
        addPane.setVisible(false);
        viewPane.setVisible(false);
        updatePane.setVisible(false);
        removePane.setVisible(false);
        if(!username.equals("admin"))
        {
            addButton.setVisible(false);
            removeButton.setVisible(false);
            updateButton.setVisible(false);
            viewButton.setLayoutX(700);
            viewButton.setLayoutY(685);
            viewKid.setLayoutY(620);
            viewKid.setLayoutX(700);
            viewSchedule.setLayoutY(620);
            viewSchedule.setLayoutX(833);
        }
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                removeButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                addTeacherButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                addKidButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                addScheduleButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                if(viewButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || removeButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || updateButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")  )
                {
                    resetButtons();
                }
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                addKidButton.setVisible(true);
                addTeacherButton.setVisible(true);
                addScheduleButton.setVisible(true);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                viewSchedule.setVisible(false);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
                name.setVisible(false);
                surname.setVisible(false);
                dateOfBirth.setVisible(false);
                parentPhone.setVisible(false);
                parentName.setVisible(false);
                parentSurname.setVisible(false);
                address.setVisible(false);
                group.setVisible(false);
                waitingList.setVisible(false);
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
                teacherName.setVisible(false);
                teacherSurname.setVisible(false);
                teacherPhone.setVisible(false);
                groupNumber.setVisible(false);
                childImage.setVisible(false);
                teachersImage.setVisible(false);
                teacherID.setVisible(false);
                workDay.setVisible(false);
                startHour.setVisible(false);
                endHour.setVisible(false);
            }
        });
        viewButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(addButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || removeButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || updateButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")  )
                {
                    resetButtons();
                }
                resetButtons();
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(true);
                if(username.equals("admin"))
                {
                    viewTeacher.setVisible(true);
                }
                viewSchedule.setVisible(true);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
                viewPane.setVisible(false);
                addPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
            }
        });
        updateButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(addButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || removeButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || viewButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px") )
                {
                    resetButtons();
                }
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    updateButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    updateButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(true);
                updateTeacher.setVisible(true);
                updateSchedule.setVisible(true);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                viewSchedule.setVisible(false);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
                updatePane.setVisible(true);
                viewPane.setVisible(false);
                addPane.setVisible(false);
                removePane.setVisible(false);
            }
        });
        removeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(addButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || viewButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")
                        || updateButton.getStyle().equals("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px")  )
                resetButtons();
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    removeButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    removeButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px;");
                }
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                viewSchedule.setVisible(false);
                removeKid.setVisible(true);
                removeTeacher.setVisible(true);
                removeSchedule.setVisible(true);
                removePane.setVisible(true);
                updatePane.setVisible(false);
                viewPane.setVisible(false);
                addPane.setVisible(false);
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Utilities.returnToLogin(event);
            }
        });

        addKidButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                addTeacherButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                addScheduleButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    addKidButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    addKidButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px;");
                }
                addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                name.setVisible(true);
                surname.setVisible(true);
                dateOfBirth.setVisible(true);
                parentPhone.setVisible(true);
                parentName.setVisible(true);
                parentSurname.setVisible(true);
                address.setVisible(true);
                group.setVisible(true);
                waitingList.setVisible(true);
                teacherName.setVisible(false);
                teacherSurname.setVisible(false);
                teacherPhone.setVisible(false);
                groupNumber.setVisible(false);
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
                childImage.setVisible(true);
                teachersImage.setVisible(false);
                teacherID.setVisible(false);
                workDay.setVisible(false);
                startHour.setVisible(false);
                endHour.setVisible(false);
            }
        });

        addTeacherButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                addKidButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                addScheduleButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    addTeacherButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    addTeacherButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px;");
                }
                addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                teacherName.setVisible(true);
                teacherSurname.setVisible(true);
                teacherPhone.setVisible(true);
                groupNumber.setVisible(true);
                name.setVisible(false);
                surname.setVisible(false);
                dateOfBirth.setVisible(false);
                parentPhone.setVisible(false);
                parentName.setVisible(false);
                parentSurname.setVisible(false);
                address.setVisible(false);
                group.setVisible(false);
                waitingList.setVisible(false);
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
                childImage.setVisible(false);
                teachersImage.setVisible(true);
            }
        });

        viewKid.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewPane.setVisible(true);
                tableKid.setVisible(true);
                tableEmp.setVisible(false);
                tableSchedule.setVisible(false);
            }
        });

        viewTeacher.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewPane.setVisible(true);
                tableKid.setVisible(false);
                tableEmp.setVisible(true);
                tableSchedule.setVisible(false);
            }
        });

        addScheduleButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                addKidButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                addTeacherButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-background-radius: 12px");
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    addScheduleButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    addScheduleButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px;");
                }
                addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                teacherID.setVisible(true);
                workDay.setVisible(true);
                startHour.setVisible(true);
                endHour.setVisible(true);
                teacherName.setVisible(false);
                teacherSurname.setVisible(false);
                teacherPhone.setVisible(false);
                groupNumber.setVisible(false);
                name.setVisible(false);
                surname.setVisible(false);
                dateOfBirth.setVisible(false);
                parentPhone.setVisible(false);
                parentName.setVisible(false);
                parentSurname.setVisible(false);
                address.setVisible(false);
                group.setVisible(false);
                waitingList.setVisible(false);
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
                childImage.setVisible(false);
                teachersImage.setVisible(false);
            }
        });

        viewSchedule.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewPane.setVisible(true);
                tableKid.setVisible(false);
                tableEmp.setVisible(false);
                tableSchedule.setVisible(true);
            }
        });
    }
}
