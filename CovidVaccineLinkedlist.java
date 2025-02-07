//672115039 Metavee Aeinjang
//This code is for ADT-Tutorial5 only !!

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class VaccineRecord {
    String vaccine;
    LocalDate firstDose;
    LocalDate secondDose;

    VaccineRecord(String vaccine, LocalDate firstDose, LocalDate secondDose) {
        this.vaccine = vaccine;
        this.firstDose = firstDose;
        this.secondDose = secondDose;
    }

    public String toString() {
        return vaccine + ", First Dose: " + firstDose + 
               ", Second Dose: " + (secondDose != null ? secondDose : "N/A");
    }
}

class CovidVaccine {
    private String sid;
    private String firstName;
    private String lastName;
    private List<VaccineRecord> previousVaccines;
    private String batchNumber;
    private String vaccinationSite;
    private String healthProvider;
    private String qrCode;
    private String vaccinationStatus;
    private String certificateID;
    private String signatureStamp;

    public CovidVaccine(String sid, String firstName, String lastName, 
                        List<VaccineRecord> previousVaccines, 
                        String batchNumber, String vaccinationSite, 
                        String healthProvider, String qrCode,
                        String vaccinationStatus, String certificateID,
                        String signatureStamp) {
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.previousVaccines = previousVaccines;
        this.batchNumber = batchNumber;
        this.vaccinationSite = vaccinationSite;
        this.healthProvider = healthProvider;
        this.qrCode = qrCode;
        this.vaccinationStatus = vaccinationStatus;
        this.certificateID = certificateID;
        this.signatureStamp = signatureStamp;
    }

    public String getSid() { return sid; }
    public String getFirstName() { return firstName; }

    public String toString() {
        return String.format("Inserted SID %s, First Name %s, Last Name %s, Previous Vaccines [%s], Batch Number %s, Vaccination Site %s, Health Provider %s, QR Code %s, Vaccination Status %s, CertificateID %s, Signature Stamp %s",
            sid, firstName, lastName, previousVaccines.get(0), batchNumber, 
            vaccinationSite, healthProvider, qrCode, vaccinationStatus, 
            certificateID, signatureStamp);
    }
}

class Node {
    CovidVaccine data;
    Node next;

    Node(CovidVaccine data) {
        this.data = data;
        this.next = null;
    }
}

class VaccineLinkedList {
    private Node head;
    private int size;

    public VaccineLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(CovidVaccine vaccine) {
        Node newNode = new Node(vaccine);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println(vaccine);
    }

    public boolean delete(String sid) {
        if (head == null) return false;

        if (head.data.getSid().equals(sid)) {
            System.out.println("Deleted " + head.data);
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.data.getSid().equals(sid)) {
                System.out.println("Deleted " + current.data);
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public void deleteAll() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void traversal() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        StringBuilder output = new StringBuilder();
        while (current != null) {
            output.append("SID ").append(current.data.getSid())
                  .append(", First Name ").append(current.data.getFirstName())
                  .append(" -> ");
            current = current.next;
        }
        output.append("List is empty");
        System.out.println(output);
    }
}

public class CovidVaccineLinkedListDemo {
    public static void main(String[] args) {
        VaccineLinkedList list = new VaccineLinkedList();
        Random random = new Random();

        List<VaccineRecord> record1 = List.of(
            new VaccineRecord("Pfizer-BioNTech", 
                LocalDate.of(2021, 6, 10), 
                LocalDate.of(2021, 7, 1))
        );

        List<VaccineRecord> record2 = List.of(
            new VaccineRecord("Pfizer-BioNTech", 
                LocalDate.of(2021, 6, 10), 
                null)
        );

        // Create 10 applicants with new names
        List<CovidVaccine> applicants = new ArrayList<>(List.of(
            new CovidVaccine("100", "Mylittle", "Pony", record1, 
                "A12345", "Clinic A", "Provider X", "QR1Code", 
                "Fully Vaccinated", "Cert-1001", "Stamp-1001"),
            new CovidVaccine("101", "Liam", "Chen", record1, 
                "B67890", "Health Center B", "Provider Y", "QR2Code", 
                "Fully Vaccinated", "Cert-1002", "Stamp-1002"),
            new CovidVaccine("102", "Aria", "Pa", record2, 
                "C23456", "Vaccination Hub C", "Provider Z", "QR3Code", 
                "Fully Vaccinated", "Cert-1003", "Stamp-1003"),
            new CovidVaccine("103", "Noah", "Nono", record1, 
                "D98765", "City Hospital D", "Provider X", "QR4Code", 
                "Fully Vaccinated", "Cert-1004", "Stamp-1004"),
            new CovidVaccine("104", "Sophia", "The first", record1, 
                "E54321", "Private Practice E", "Provider Y", "QR5Code", 
                "Fully Vaccinated", "Cert-1005", "Stamp-1005"),
            new CovidVaccine("105", "Taylor", "Swift", record2, 
                "A12345", "Clinic A", "Provider Z", "QR6Code", 
                "Fully Vaccinated", "Cert-1006", "Stamp-1006"),
            new CovidVaccine("106", "Sabrina", "Carpenter", record2, 
                "B67890", "Health Center B", "Provider X", "QR7Code", 
                "Fully Vaccinated", "Cert-1007", "Stamp-1007"),
            new CovidVaccine("107", "Meow", "Meowmeow", record1, 
                "C23456", "Vaccination Hub C", "Provider Z", "QR8Code", 
                "Fully Vaccinated", "Cert-1008", "Stamp-1008"),
            new CovidVaccine("108", "Oat", "Piggy", record2, 
                "D98765", "City Hospital D", "Provider Y", "QR9Code", 
                "Fully Vaccinated", "Cert-1009", "Stamp-1009"),
            new CovidVaccine("109", "Metvee", "Cutie", record1, 
                "E54321", "Private Practice E", "Provider X", "QR10Code", 
                "Fully Vaccinated", "Cert-1010", "Stamp-1010")
        ));

        for (CovidVaccine vaccine : applicants) {
            list.insert(vaccine);
        }

        // Randomly delete two applicants
        for (int i = 0; i < 2; i++) {
            String sidToDelete = applicants.get(random.nextInt(applicants.size())).getSid();
            list.delete(sidToDelete);
        }

        list.traversal();
    }
}