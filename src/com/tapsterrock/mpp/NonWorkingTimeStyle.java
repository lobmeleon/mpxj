/*
 * file:       NonWorkingTimeStyle.java
 * author:     Jon Iles
 * copyright:  (c) Tapster Rock Limited 2005
 * date:       Apr 7, 2005
 */
 
package com.tapsterrock.mpp;

/**
 * Class representing how non-working time is shown on a Gantt chart.
 */
public final class NonWorkingTimeStyle
{
   /**
    * Private constructor.
    * 
    * @param value alignment value from an MS Project file
    */
   private NonWorkingTimeStyle (int value)
   {
      m_value = value;
   }
   
   /**
    * Retrieve an instance of this class based on the data read from an
    * MS Project file.
    * 
    * @param value value from an MS Project file
    * @return instance of this class
    */
   public static NonWorkingTimeStyle getInstance (int value)
   {  
      NonWorkingTimeStyle result;
      
      if (value < 0 || value >= STYLE_ARRAY.length)
      {
         value = 1;
      }
      
      result = STYLE_ARRAY[value];
      
      return (result);
   }

   /**
    * Retrieve the name of this alignment. Note that this is not
    * localised.
    * 
    * @return name of this alignment type
    */
   public String getName ()
   {
      return (STYLE_NAMES[m_value]);
   }
   
   /**
    * Generate a string representation of this instance.
    * 
    * @return string representation of this instance
    */
   public String toString ()
   {
      return (getName());
   }

   /**
    * Retrieve the value associated with this instance.
    * 
    * @return int value
    */
   public int getValue ()
   {
      return (m_value);
   }
   
   public static final int BEHIND_VALUE = 0;
   public static final int IN_FRONT_VALUE = 1;
   public static final int DO_NOT_DRAW_VALUE = 2;
   
   public static final NonWorkingTimeStyle BEHIND = new NonWorkingTimeStyle (BEHIND_VALUE);
   public static final NonWorkingTimeStyle IN_FRONT = new NonWorkingTimeStyle (IN_FRONT_VALUE);
   public static final NonWorkingTimeStyle DO_NOT_DRAW = new NonWorkingTimeStyle (DO_NOT_DRAW_VALUE);

   private static final NonWorkingTimeStyle[] STYLE_ARRAY =
   {
      BEHIND,
      IN_FRONT,
      DO_NOT_DRAW
   };
   
   private static final String[] STYLE_NAMES = 
   {
      "Behind",
      "In Front",
      "Do Not Draw",
   };
   
   private int m_value;
}