(ns week2.test-calculatrix
  (:use midje.sweet
        week2.calculatrix))

(facts "read-words"
       (with-in-str "foo bar" (read-words)
         => ["foo" "bar"]))

(facts "string->number"
       )

(facts "compute"
       )

(facts "main"
       )
