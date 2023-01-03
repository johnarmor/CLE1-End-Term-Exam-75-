import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Forever Gems");
        ImageIcon icon = null;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelTitle = new JPanel(new FlowLayout());
        JPanel panelOne = new JPanel(new GridLayout(3, 3, 1, 1));
        JPanel panelTwo = new JPanel(new FlowLayout());
        JButton button = new JButton("Press Button to Compute");
        JButton button1 = new JButton("About Forever Gems");

        panelTitle.setBounds(10, 10, 360, 60);
        panelOne.setBounds(10, 100, 360, 90);
        panelTwo.setBounds(10, 200, 360, 40);

        frame.getContentPane().setBackground(Color.pink);
        panelTitle.setBackground(Color.black);
        panelOne.setBackground(Color.pink);
        panelTwo.setBackground(Color.black);

        JLabel labelOne, labelTwo, labelTitle;

        labelTitle = new JLabel("Jewelry that’s as beautiful as you are", JLabel.CENTER);
        labelOne = new JLabel("Please pick a body:");
        labelTwo = new JLabel("Please pick a gem:");

        labelTitle.setForeground(Color.white);

        labelTitle.setBounds(10, 10, 90, 20);
        labelOne.setBounds(10, 60, 90, 20);
        labelTwo.setBounds(10, 10, 150, 50);

        panelTitle.add(labelTitle);

        panelOne.add(labelOne);

        String[] Body = {"Gold Bracelet", "Gold Necklace", "Gold Ring", "Silver Earrings", "Silver Bracelet", "Platinum Earrings"};
        final JComboBox drop1 = new JComboBox(Body);
        drop1.setBounds(100, 140, 80, 25);
        panelOne.add(drop1);

        panelOne.add(labelTwo);

        String[] Jewel = {"Diamond", "Emerald", "Ruby"};
        final JComboBox drop2 = new JComboBox(Jewel);
        drop2.setBounds(100,140,80,25);
        panelOne.add(drop2);

        button.setBounds(10, 10, 90, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = Compute.PriceCompute((String) drop1.getSelectedItem(),(String) drop2.getSelectedItem());
                Compute.displayResult(String.valueOf(result));
            }
        });

        button1.setBounds(10, 10, 90, 20);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("dia.png"));
                JOptionPane.showMessageDialog(null, "Forever Gems is the leading jewelry customization seller in the country " +
                        "\nwith various offering such as bracelets, ear rings, necklaces and rings." +
                        "\nGold and silver are the primary materials, with diamonds " +
                        "\nand other precious stones are available for clients choosing.", "About", JOptionPane.INFORMATION_MESSAGE, icon1);
            }
        });

        java.net.URL imgURL = Main.class.getResource("icon.png");
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
            frame.setIconImage(icon.getImage());
        } else {
            JOptionPane.showMessageDialog(frame, "Icon image not found.");
        }

        panelTitle.add(button1);
        panelTwo.add(button);

        frame.add(panelTitle);
        frame.add(panelOne);
        frame.add(panelTwo);

        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

abstract class Price {
    public void displayMessage() {
        System.out.println("Placeholder");
    }
}
class Compute extends Price {
    public static int PriceCompute(String value1, String value2) {

        String[] drop1 = {"Gold Bracelet", "Gold Necklace", "Gold Ring", "Silver Earrings", "Silver Bracelet", "Platinum Earrings"};
        String[] drop2 = {"Diamond", "Emerald", "Ruby"};

        int[] box1price = {15000, 17000, 12000, 8000, 8000, 18000};
        int[] box2price = {50000, 20000, 25000};

        int labor = 5000;
        int overhead = 5000;
        int price1, price2;

        String BodyType = value1;
        String Jewel = value2;

        //Body
        if (BodyType == drop1[0]) {
            price1 = box1price[0];
        } else if (BodyType == drop1[1]) {
            price1 = box1price[1];
        } else if (BodyType == drop1[2]) {
            price1 = box1price[2];
        } else if (BodyType == drop1[3]) {
            price1 = box1price[3];
        } else if (BodyType == drop1[4]) {
            price1 = box1price[4];
        } else {
            price1 = box1price[5];
        }
        //Jewel
        if (Jewel == drop2[0]) {
            price2 = box2price[0];
        } else if (Jewel == drop2[1]) {
            price2 = box2price[1];
        } else {
            price2 = box2price[2];
        }
        int cost = (price1 + price2 + labor + overhead);
        int itemprice = cost;
        return itemprice;
    }
    public static void displayResult (String itemprice){
        int ayitemprice = Integer.parseInt(String.valueOf(itemprice));
        double wprice = (ayitemprice * 0.5);
        double rprice = (wprice * 0.5);
        final ImageIcon icon1 = new javax.swing.ImageIcon(Compute.class.getResource("piso.png"));
        JOptionPane.showMessageDialog(null, "Wholesale Price: ₱" + wprice +
                        "\nRetail Price: ₱" + rprice,
                "Result", JOptionPane.INFORMATION_MESSAGE, icon1);
    }
}