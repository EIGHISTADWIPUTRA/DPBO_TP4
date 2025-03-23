import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Menu extends JFrame{
    public static void main(String[] args) {
        Menu window = new Menu();
        window.setSize(550, 600);
        window.setLocationRelativeTo(null);
        window.setContentPane(window.mainPanel);
        window.getContentPane().setBackground(Color.WHITE);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int selectedIndex = -1;
    private ArrayList<Mahasiswa> listMahasiswa;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel nilaiLabel;
    private JComboBox nilaiComboBox;
    private JLabel kelasLabel;
    private JRadioButton c1RadioButton;
    private JRadioButton c2RadioButton;
    private ButtonGroup kelasButtonGroup;
    private JLabel umurLabel;
    private JSpinner umurSpinner;

    public Menu() {
        listMahasiswa = new ArrayList<>();

        kelasButtonGroup = new ButtonGroup();
        kelasButtonGroup.add(c1RadioButton);
        kelasButtonGroup.add(c2RadioButton);

        populateList();

        mahasiswaTable.setModel(setTable());

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nimLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        namaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        jenisKelaminLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nilaiLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        kelasLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        umurLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        jenisKelaminComboBox.addItem("Laki-laki");
        jenisKelaminComboBox.addItem("Perempuan");

        nilaiComboBox.addItem("A");
        nilaiComboBox.addItem("B");
        nilaiComboBox.addItem("C");
        nilaiComboBox.addItem("D");
        nilaiComboBox.addItem("E");

        SpinnerNumberModel model = new SpinnerNumberModel(20, 15, 30, 1);
        umurSpinner.setModel(model);

        c1RadioButton.setSelected(true);

        deleteButton.setVisible(false);

        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    if (selectedIndex == -1) {
                        insertData();
                    } else {
                        updateData();
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin menghapus data ini?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    deleteData();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = mahasiswaTable.getSelectedRow();

                String nim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();
                String nama = mahasiswaTable.getValueAt(selectedIndex, 2).toString();
                String jenisKelamin = mahasiswaTable.getValueAt(selectedIndex, 3).toString();
                String nilai = mahasiswaTable.getValueAt(selectedIndex, 4).toString();
                String kelas = mahasiswaTable.getValueAt(selectedIndex, 5).toString();
                int umur = Integer.parseInt(mahasiswaTable.getValueAt(selectedIndex, 6).toString());

                nimField.setText(nim);
                namaField.setText(nama);
                jenisKelaminComboBox.setSelectedItem(jenisKelamin);
                nilaiComboBox.setSelectedItem(nilai);

                if (kelas.equals("C1")) {
                    c1RadioButton.setSelected(true);
                } else {
                    c2RadioButton.setSelected(true);
                }

                umurSpinner.setValue(umur);

                addUpdateButton.setText("Update");

                deleteButton.setVisible(true);
            }
        });
    }

    private boolean validateForm() {
        String nim = nimField.getText().trim();
        String nama = namaField.getText().trim();

        StringBuilder errorMessage = new StringBuilder();

        if (nim.isEmpty()) {
            errorMessage.append("- NIM tidak boleh kosong\n");
        }

        if (nama.isEmpty()) {
            errorMessage.append("- Nama tidak boleh kosong\n");
        }

        if (!c1RadioButton.isSelected() && !c2RadioButton.isSelected()) {
            errorMessage.append("- Kelas harus dipilih\n");
        }

        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Mohon lengkapi data berikut:\n" + errorMessage.toString(),
                    "Validasi Form",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        return true;
    }

    public final DefaultTableModel setTable() {

        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Nilai", "Kelas", "Umur"};

        DefaultTableModel tableModel = new DefaultTableModel(null, column);

        for (int i = 0; i < listMahasiswa.size(); i++) {
            Object[] row = new Object[7];
            row[0] = i + 1;
            row[1] = listMahasiswa.get(i).getNim();
            row[2] = listMahasiswa.get(i).getNama();
            row[3] = listMahasiswa.get(i).getJenisKelamin();
            row[4] = listMahasiswa.get(i).getNilai();
            row[5] = listMahasiswa.get(i).getKelas();
            row[6] = listMahasiswa.get(i).getUmur();

            tableModel.addRow(row);
        }

        return tableModel;
    }

    public void insertData() {
        String nim = nimField.getText().trim();
        String nama = namaField.getText().trim();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String nilai = nilaiComboBox.getSelectedItem().toString();
        String kelas = c1RadioButton.isSelected() ? "C1" : "C2";
        int umur = (Integer) umurSpinner.getValue();

        listMahasiswa.add(new Mahasiswa(nim, nama, jenisKelamin, nilai, kelas, umur));

        mahasiswaTable.setModel(setTable());

        clearForm();

        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    }

    public void updateData() {
        String nim = nimField.getText().trim();
        String nama = namaField.getText().trim();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String nilai = nilaiComboBox.getSelectedItem().toString();
        String kelas = c1RadioButton.isSelected() ? "C1" : "C2";
        int umur = (Integer) umurSpinner.getValue();

        listMahasiswa.get(selectedIndex).setNim(nim);
        listMahasiswa.get(selectedIndex).setNama(nama);
        listMahasiswa.get(selectedIndex).setJenisKelamin(jenisKelamin);
        listMahasiswa.get(selectedIndex).setNilai(nilai);
        listMahasiswa.get(selectedIndex).setKelas(kelas);
        listMahasiswa.get(selectedIndex).setUmur(umur);

        mahasiswaTable.setModel(setTable());

        clearForm();

        JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
    }

    public void deleteData() {
        listMahasiswa.remove(selectedIndex);

        mahasiswaTable.setModel(setTable());

        clearForm();

        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
    }

    public void clearForm() {
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedIndex(0);
        nilaiComboBox.setSelectedIndex(0);
        c1RadioButton.setSelected(true);
        umurSpinner.setValue(20);

        addUpdateButton.setText("Add");

        deleteButton.setVisible(false);

        selectedIndex = -1;
    }

    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "Perempuan", "A", "C1", 19));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "Laki-laki", "B", "C2", 20));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "Laki-laki", "A", "C1", 21));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "Laki-laki", "B", "C1", 19));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "Perempuan", "A", "C2", 20));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "Laki-laki", "C", "C1", 22));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "Perempuan", "A", "C2", 21));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "Perempuan", "B", "C1", 20));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "Laki-laki", "A", "C2", 19));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "Laki-laki", "B", "C1", 20));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "Laki-laki", "A", "C2", 22));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "Perempuan", "C", "C1", 21));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "Laki-laki", "B", "C2", 20));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "Laki-laki", "A", "C1", 19));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "Laki-laki", "B", "C2", 20));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "Laki-laki", "A", "C1", 21));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "Laki-laki", "C", "C2", 19));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "Perempuan", "B", "C1", 20));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "Laki-laki", "A", "C2", 21));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "Perempuan", "B", "C1", 20));
    }
}