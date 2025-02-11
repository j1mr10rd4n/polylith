(ns polylith.clj.core.command.cmd-validator.project-test
  (:require [clojure.test :refer :all]
            [polylith.clj.core.util.interface.color :as color]
            [polylith.clj.core.command.cmd-validator.project :as project]))

(def projects [{:alias "adm"}
               {:name "default"}])

(deftest validate--find-by-alias--returns-with-no-error
  (is (= (project/validate #{"adm"} projects color/none)
         nil)))

(deftest validate--find-by-name--returns-with-no-error
  (is (= (project/validate #{"default"} projects color/none)
         nil)))

(deftest validate--cant-find--returns-with-error
  (is (= (project/validate #{"core"} projects color/none)
         ["  Can't find project: core"])))
