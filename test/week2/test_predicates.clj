(ns week2.test-predicates
  (:use midje.sweet
        week2.predicates))


(facts "generic doublificate"
       (generic-doublificate 1)      => 2
       (generic-doublificate [1 2])  => (just [2 4])
       (generic-doublificate {})     => nil?
       (generic-doublificate [])     => nil?
       (generic-doublificate {:a 1}) => true)

(facts "empty-string?"
       (empty-string? " \t\n\t ") => true
       (empty-string? "  \t a")   => false
       (empty-string? "")         => true)

(def pos-even? (pred-and even? pos?))

(def has-title-and-author? (pred-and :title :author))

(facts "pred-and"
       (pos-even? 12) => true
       (filter (pred-and even? pos?) [-2 5 12 20]) => (just 12 20)
       (has-title-and-author? {:author "China Miéville"
                               :title "The City and the City"})
           => "China Miéville"
       (has-title-and-author? {:title "Author unknown"})
           => nil)

(def books [{:author "China Miéville" :title "Kraken"} 
            {:author "China Miéville" :title "The City and the City"} 
            {:author "Haruki Murakami" :title "Norwegian Wood"} 
            {:author "Guy Gavriel Kay" :title "Under Heaven"}])

(facts "every-book-has-a-title?"
       (every-book-has-a-title? books) => true
       (every-book-has-a-title? [{:author "I don't have a book"}]) => false)
