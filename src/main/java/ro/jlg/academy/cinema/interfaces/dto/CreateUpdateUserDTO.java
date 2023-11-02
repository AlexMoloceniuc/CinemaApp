package ro.jlg.academy.cinema.interfaces.dto;

import java.time.LocalDateTime;

public class CreateUpdateUserDTO {

        private String name;
        private int money;
        private LocalDateTime dateOfBirth;

        public CreateUpdateUserDTO(final String name,final int money, final LocalDateTime dateOfBirth){

            this.dateOfBirth=dateOfBirth;
            this.money=money;
            this.name=name;
        }


        public String getName() {
            return this.name;
        }

        public int getMoney() {
            return this.money;
        }

        public LocalDateTime getDateOfBirth() {
            return this.dateOfBirth;
        }
    }


