# Opacity

A Clojure library to calculate and chart data from governments and businesses
that sheds light on **opacity** and helps increase transparency in budgets and planning.

## Usage

### United States

#### Illinois

##### Chicago

* **Chicago Public Schools (CPS)**
  
  This is a brief summary of simple budget numbers per school and student.
  The wide range of per-student school funding is typically based on the 
  poverty level of the neighborhood attendance. For example, schools serving 
  lower income neighborhoods might receive more money per student to help provide
  more teacher assistance, while wealthier neighborhoods rely on individual donations
  + tax funding to pay their teachers.
  
  - resources: 
    * http://cps.edu/FY16Budget/Pages/FY16Budget.aspx
    * http://cps.edu/FY17Budget/Pages/FY17Budget.aspx
    * http://cps.edu/FY18Budget/Pages/FY18Budget.aspx
  - see opacity.us.il.chicago.cps.clj
  ```clojure
  ; Load 2018 simple school 2018 budget data (courtesy Chicago Sun Times)
  (def cps (load-cps-budget (str resources "cps-budget-2018.txt")))

   ; Determine student budget by school
  (def school_student_budget (school-per-student-budget cps))

  ; Sort descending
  (def sorted_budget (ct/sort-map-by-value school_student_budget))
 
  ; Top 50 (of 643 listed) largest student budgets schools
  (pprint (take 50 sorted_budget))
 
  (["BLAIR" 47786.92957746479]
   ["BEARD" 41618.75342465754]
   ["RUDOLPH" 35659.958333333336]
   ["NORTHSIDE LEARNING HS" 27537.159420289856]
   ["SOUTHSIDE HS" 26906.0641025641]
   ["GRAHAM HS" 26347.5]
   ["VAUGHN HS" 20880.51]
   ["HOPE HS" 18163.41176470588]
   ["NEIL" 16966.65882352941]
   ["CHRISTOPHER" 16486.597435897434]
   ["TEAM HS" 15331.453703703704]
   ["HARPER HS" 14445.146153846154]
   ["CAMELOT  GARFIELD" 13511.0625]
   ["ROBESON HS" 13342.791666666666]
   ["HIRSCH HS" 13274.413223140496]
   ["MANLEY HS" 12656.317073170732]
   ["HEARST" 12370.375]
   ["HUGHES L" 12002.154285714285]
   ["TILDEN HS" 11990.765873015873]
   ["HARLAN HS" 11968.806539509536]
   ["CORLISS HS" 11934.309446254072]
   ["DOUGLASS HS" 11925.681818181818]
   ["SIMPSON HS" 11904.384615384615]
   ["CAMELOT SAFE" 11894.5]
   ["VOISE HS" 11891.456896551725]
   ["LOZANO" 11868.787878787878]
   ["UPLIFT HS" 11848.374074074074]
   ["DUNBAR HS" 11821.917840375587]
   ["DETT" 11714.597457627118]
   ["WELLS HS" 11691.279605263158]
   ["SPRY HS" 11561.12]
   ["HENDRICKS" 11521.009852216748]
   ["PEACE AND EDUCATION HS" 11468.607476635514]
   ["CHASE" 11388.53825136612]
   ["MCCUTCHEON" 11285.39263803681]
   ["BOWEN HS" 11213.14381270903]
   ["SUDER" 11080.23197492163]
   ["BROWN W" 11054.444015444016]
   ["TELPOCHCALLI" 10981.99604743083]
   ["COURTENAY" 10799.368131868132]
   ["MCNAIR" 10704.406332453826]
   ["FENGER HS" 10682.261083743842]
   ["YATES" 10650.29702970297]
   ["RYDER" 10642.383040935672]
   ["BRIGHT" 10629.776515151516]
   ["THORP J" 10600.581632653062]
   ["GALE" 10596.8940397351]
   ["SOLOMON" 10494.646666666667]
   ["KERSHAW" 10473.547413793103]
   ["OTIS" 10470.208333333334])
  ```
  

## License

Copyright © 2017 David Millett

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
