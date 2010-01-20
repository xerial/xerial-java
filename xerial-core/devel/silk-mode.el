;;--------------------------------------------------------------------------
;;  Copyright 2009 Taro L. Saito
;;
;;   Licensed under the Apache License, Version 2.0 (the "License");
;;   you may not use this file except in compliance with the License.
;;   You may obtain a copy of the License at
;; 
;;      http://www.apache.org/licenses/LICENSE-2.0
;; 
;;   Unless required by applicable law or agreed to in writing, software
;;   distributed under the License is distributed on an "AS IS" BASIS,
;;   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;;   See the License for the specific language governing permissions and
;;   limitations under the License.
;;--------------------------------------------------------------------------
;;---------------------------
;; silk-mode.el
;;
;; Created by: Taro L. Saito
;; Since: Aug 30, 2009
;;
;; $URL: https://www.xerial.org/svn/leo/trunk/devel/emacs-lisp/silk-mode.el $
;; $Author: leo $ 
;;--------------------------- 

(defconst silk-mode-revision "$Revision: 808 $")
 
(defconst silk-mode-version
  (progn
   (string-match "[0-9.]+" silk-mode-revision)
   (substring silk-mode-revision (match-beginning 0) (match-end 0))))


(defun silk-mode ()
  "Major mode for editing Silk format data in Emacs."
  (interactive)
  (kill-all-local-variables)
  (setq major-mode 'silk-mode)
  (setq mode-name "Silk")
  (make-variable-buffer-local 'comment-start)
  (setq comment-start "# ")
  (make-variable-buffer-local 'comment-end)
  (setq comment-end "")
  (make-variable-buffer-local 'comment-start-skip)
  (setq comment-start-skip "#+ *")
  (make-local-variable 'parse-sexp-ignore-comments)
  (setq parse-sexp-ignore-comments t)

  (set-syntax-table silk-mode-syntax-table)
  (use-local-map silk-mode-map)
  (set (make-local-variable 'font-lock-defaults) 
       '(silk-font-lock-keywords nil nil))
  (run-hooks 'silk-mode-hook))

(defvar silk-mode-map
  (let ((map (make-sparse-keymap)))
;    (define-key map "\C-jn" 'silk-node)
    map)
  "Keymap for Silk mode.")



(defvar silk-font-lock-keywords
  (list
   '("^ *%[^\n]+" (0 font-lock-preprocessor-face))
   '("^ *[->]+\\([^-@(,:>|\n]*\\)" (1 font-lock-keyword-face t) 
     ("[,(] *\\([^:,()\n\\[]+\\)" nil nil (1 font-lock-constant-face t))
     ("\\[[A-Za-z/0-9]+\\]" nil nil (0 font-lock-type-face t)))
   '("@\\([^(\n]+\\)(" (1 font-lock-function-name-face t))
   '("\\\"[^\\\"]*\\\"" (0 font-lock-string-face t))
   '("#[^\n]*" (0 font-lock-comment-face t))
   '("^ *--" (0 font-lock-builtin-face t))
   '(")\\(>>?|\|\\)" (1 font-lock-builtin-face t))
  ))

(defvar silk-mode-syntax-table nil
  "Syntax table in use in silk-mode buffers.")

(if silk-mode-syntax-table
    ()
  (progn
    (setq silk-mode-syntax-table (make-syntax-table))
    (modify-syntax-entry ?\" "\"" silk-mode-syntax-table)
;    (modify-syntax-entry ?\' "\"" silk-mode-syntax-table)
    (modify-syntax-entry ?# "<" silk-mode-syntax-table)
    (modify-syntax-entry ?\n ">" silk-mode-syntax-table)
    (modify-syntax-entry ?\\ "\\" silk-mode-syntax-table)
    (modify-syntax-entry ?- "." silk-mode-syntax-table)
    (modify-syntax-entry ?\( "." silk-mode-syntax-table)
    (modify-syntax-entry ?\) "." silk-mode-syntax-table)
    (modify-syntax-entry ?\{ "(}" silk-mode-syntax-table)
    (modify-syntax-entry ?\} "){" silk-mode-syntax-table)
    (modify-syntax-entry ?\[ "(]" silk-mode-syntax-table)
    (modify-syntax-entry ?\] ")[" silk-mode-syntax-table)))



(defvar silk-font-lock-syntactic-keywords nil)


(defun silk-node ()
  (interactive)
  (insert "-node()"))


(provide 'silk-mode)

