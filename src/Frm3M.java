/*
Created by Conner Recoskie
Date: May 6th
Purpose: This program calculates the mean, median, and  mode of a data set. The
user has the ability to enter and/or remove values to make there own data set,
to witch then the program can find the mean, median, and ,mode of. 
*/

// Importing the packages needed in the program
import java.util.ArrayList;
import java.util.Collections;

public class Frm3M extends javax.swing.JFrame {
    // Creating an array list to hold the user inputs
    ArrayList <Integer> numbers = new ArrayList <> ();
    // Creating an integer variable to hold the input value
    int integerValue = 0;
    
    // Creating an integer variable to keep track of the amount of inputs there is
    int amountOfInputs;
    
    /*
    Function: round
    Purpose: This method rounds a given number to two decimal places.
    Parameters: double amount repersents the amount that is going to be rounded.
    Returns: double
    */
    public static double round (double amount)
    {
        amount = amount * 100.0;
        amount = Math.round(amount);
        amount = amount/100.0;
        
        return amount;
    }

    public Frm3M() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblInstruction = new javax.swing.JLabel();
        txtInteger = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCalculate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutputWindow = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        lblTitle.setText("<html><u>Mean Median And Mode Calculator</u></html>");

        lblInstruction.setFont(new java.awt.Font("Sitka Heading", 0, 13)); // NOI18N
        lblInstruction.setText("Input Value:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtOutputWindow.setColumns(20);
        txtOutputWindow.setRows(5);
        jScrollPane1.setViewportView(txtOutputWindow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInstruction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInteger))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstruction)
                    .addComponent(txtInteger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addGap(42, 42, 42)
                        .addComponent(btnCalculate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Error checking user input
        try
        {
            // Attempting to parse the integer input from the text field
            integerValue = Integer.parseInt(txtInteger.getText());
        }
        catch (NumberFormatException e)
        {
            // If parsing fails, display "Invalid Input" in the output window
            txtOutputWindow.setText("Invalid Input");
        }
        
        // Clearing the output window
        txtOutputWindow.setText("");
        
         // Check if the input is within the valid range of 0 to 100
        if ((integerValue >= 0) && (integerValue <= 100))
        {
            // Add the input to the ArrayList
            numbers.add(integerValue);
            
            // Increment the total number of inputs by 1
            amountOfInputs += 1;
            
             // Looping through all the inputs in the ArrayList
            for (int i = 0; i < amountOfInputs; i++)
            {
                // Get the input at index i and add a new line character to a String
                String num = numbers.get(i) + "\n";
                
                // Append the input to the output window
                txtOutputWindow.append(num);
            }
        } 
        else
        {
            // If the input is outside the valid range, display "Invalid Input" in the output window
            txtOutputWindow.setText("Invalid Input");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // Creating variables to be used in the process of removing a value
        int removal = -1;
        boolean isRemoved = false;
        
        // Error checking user input
        try
        {
            // Attempting to parse the integer input from the text field
            integerValue = Integer.parseInt(txtInteger.getText());
        }
        catch (NumberFormatException e)
        {
            // If parsing fails, display "Invalid Input" in the output window
            txtOutputWindow.setText("Invalid Input");
        }
        
         // Looping through all the inputs in the ArrayList
        for (int i = 0; i < amountOfInputs; i++)
        {
            // Checking if the input matches an input in the ArrayList
            if (integerValue == numbers.get(i))
            {
                 // Set the index of the input to be removed as i
                removal = i;
                
                // Set the boolean variable to true
                isRemoved = true;
                
                // Exit the loop
                break;
            }
        } 

        // Check if the input has been found in the array list
        if (isRemoved)
        {
            // Remove the input from the ArrayList
            numbers.remove(removal);
            
            // Decrement the total number of inputs by 1
            amountOfInputs -= 1;
            
             // Clear the output window
            txtOutputWindow.setText("");
            
            // Set the title for the list of inputs
            String title = "Inputs: " + "\n";
            
            // Appending the title to the output window
            txtOutputWindow.append(title);
            
            // Looping through all the remaining inputs in the ArrayList
            for (int i = 0; i < amountOfInputs; i++)
            {
                // Get the input at index i and add a new line character
                String num = numbers.get(i) + "\n"; 
                
                // Append the input to the output window
                txtOutputWindow.append(num);
            }
        }
        else
        {
            // If the input has not been found, display "Number not found" in the output window
            txtOutputWindow.setText("Number not found");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // Initialize the mean as 0
        double mean = 0;
        
        // initialize the median
        double median;
        
        // initialize the mode
        double mode;
        
        // Get the size of the numbers arrayList
        int size = numbers.size();
        
        // Sort the list of numbers in ascending order
        Collections.sort(numbers);
        
        // Iterate through the list of numbers and calculate the sum
        for (int i = 0; i < size; i++)
        {
            mean += numbers.get(i);
        }
        
        // Calculate the mean
        mean = mean/amountOfInputs;
        
        // Check if the size of the "numbers" ArrayList is odd or even to determine median calculation
        if (numbers.size() %2 == 1) 
        {
            // Getting median if array list size is even
            median = (double)numbers.get(size/2);
        } 
        else
        {
            // Getting median if array list size is odd
            median = ((double)numbers.get(size/2) + (double)numbers.get(size/2 - 1))/2;
        }
        
        // Initialize variables for finding the mode
        int maxCount = 0;
        double maxValue = 0;
        
        // Looping through the numbers array to find the "single" mode
        for (int i = 0; i < size; i++)
        {
            int count = 0;
            for (int j = 0; j < size; j++)
            {
                if (numbers.get(j).equals(numbers.get(i)))
                {
                    count++;
                }
            }
            
            // Check if current number occurs more times than previous modes
            if (count > maxCount) 
            {
                maxCount = count;
                maxValue = numbers.get(i);
            }
        }
        
        // If no number appeares more than once, there is no mode
        if (maxCount == 1) 
        {
            mode = Double.NaN;
        } 
        else
        {
            mode = maxValue;
        }
        
        // Rounding the mean
        mean = round(mean);
        
        // Set the text for the output window with the calculated mean, median and mode
        txtOutputWindow.setText("The mean is: " + mean + "." + "\n" + "The median is: "
                + median + "." +"\n" + "The mode is: " + mode + ".");
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // Clearing the array list
        numbers.clear();
        
        // Clearing the output window
        txtOutputWindow.setText("");
        
        // Setting the amount of inputs to 0
        amountOfInputs = 0;
    }//GEN-LAST:event_btnClearActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm3M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm3M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm3M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm3M.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm3M().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInstruction;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtInteger;
    private javax.swing.JTextArea txtOutputWindow;
    // End of variables declaration//GEN-END:variables
}