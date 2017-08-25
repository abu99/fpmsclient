/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client.widgets;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.service.ProductMngrService;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

/**
 *
 * @author faizbash
 */
public class WidgetsFactory {

//    public static void setSession(final CustomListBox<SessionDto> list) {
//	list.removeAllItems();
//        list.addListItem(SessionDto.getEmptySession());
//
//        //set from chache if available
//        if (CacheManager.getSessions() != null) {
//            list.addItems(CacheManager.getSessions());
//            return;
//        }
//
//	SessionMngrService.Util.getService().getAvailableSessions(
//		new AsyncCallback<List<SessionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting sessions.");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SessionDto> result) {
//		for (SessionDto session: result) {
//		    list.addListItem(session);
//		}
//	    }
//	});
//    }
//    
//    public static void setSession(final CustomListBox<SessionDto> list,
//            final WidgetReadyHandler wrh) {
//        
//	list.removeAllItems();
//        list.addListItem(SessionDto.getEmptySession());
//
//        //set from chache if available
//        if (CacheManager.getSessions() != null) {
//            list.addItems(CacheManager.getSessions());
//            return;
//        }
//
//	SessionMngrService.Util.getService().getAvailableSessions(
//		new AsyncCallback<List<SessionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting sessions.");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SessionDto> result) {
//		for (SessionDto session: result) {
//		    list.addListItem(session);
//		}
//                
//                if (wrh != null)
//                    wrh.widgetReady();
//	    }
//	});
//    }
//    
//    public static void setSessionWoEmptySelect(final CustomListBox<SessionDto> list,
//            final WidgetReadyHandler wrh) {
//        
//	list.removeAllItems();
//
//        //set from chache if available
//        if (CacheManager.getSessions() != null) {
//            list.addItems(CacheManager.getSessions());
//            return;
//        }
//
//	SessionMngrService.Util.getService().getAvailableSessions(
//		new AsyncCallback<List<SessionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting sessions.");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SessionDto> result) {
//		for (SessionDto session: result) {
//		    list.addListItem(session);
//		}
//                
//                if (wrh != null)
//                    wrh.widgetReady();
//	    }
//	});
//    }
//    
//    public static void setSession(final CustomListBox<SessionDto> list,
//            final String sessionId) {
//	list.removeAllItems();
//        list.addListItem(SessionDto.getEmptySession());
//
//        setSession(list);
//        if (sessionId != null && !sessionId.equalsIgnoreCase("")) {
//            list.setSelectedItem(new SessionDto(sessionId, 0, 0));
//        }
//        
//    }
//    
//    public static void setSession(final CustomListBox<SessionDto> list,
//            final SessionDto session) {
//	list.removeAllItems();
//        list.addListItem(SessionDto.getEmptySession());
//
//        setSession(list);
//        list.setSelectedItem(session);
//    }
//
//    public static void setTerm(final CustomListBox<TermDto> list) {
//	list.removeAllItems();
//        list.addListItem(TermDto.getEmptyTerm());
//
//        //set from chache if available
//        //if (CacheManager.getSessions() != null) {
//          //  list.addItems(CacheManager.getSessions());
//            //return;
//        //}
//
//	TermConfigMngrService.Util.getService().getTerms(
//		new AsyncCallback<List<TermDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting terms.");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDto> result) {
//		for (TermDto term: result) {
//		    list.addListItem(term);
//		}
//	    }
//	});
//    }
//    
//    public static void setTerm(final CustomListBox<TermDto> list,
//            final TermDto termDto) {
//	list.removeAllItems();
//        list.addListItem(TermDto.getEmptyTerm());
//
//	TermConfigMngrService.Util.getService().getTerms(
//		new AsyncCallback<List<TermDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting terms.");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDto> result) {
//		LoadingWidget.INSTANCE.hide();
//		list.addItems(new ArrayList<TermDto>(result));
//                list.setSelectedItem(termDto);
//	    }
//	});
//        
//    }
//
//    public static void setTermWithEmptySelectOnly(final CustomListBox<TermDto> list) {
//	list.removeAllItems();
//        list.addListItem(TermDto.getEmptyTerm());
//    }
//
//    public static void setSessionOfAdmission(final CustomListBox<SessionDto> list) {
//	list.removeAllItems();
//        list.addListItem(SessionDto.getEmptySessionOfAdmission());
//
//        //set from chache if available
//        if (CacheManager.getSessions() != null) {
//            list.addItems(CacheManager.getSessions());
//            return;
//        }
//
//	SessionMngrService.Util.getService().getAvailableSessions(
//		new AsyncCallback<List<SessionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting sessions.");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SessionDto> result) {
//		for (SessionDto session: result) {
//		    list.addListItem(session);
//		}
//	    }
//	});
//    }
//    
//    public static void setSessionOfAdmission(final CustomListBox<SessionDto> list,
//            final String sessionId) {
//	list.removeAllItems();
//        list.addListItem(SessionDto.getEmptySessionOfAdmission());
//
//        setSession(list);
//        if (sessionId != null && !sessionId.equalsIgnoreCase("")) {
//            list.setSelectedItem(new SessionDto(sessionId, 0, 0));
//        }
//        
//    }
//    
//    public static void setOnlySelectState(CustomListBox<StateDto> listBox) {
//	listBox.setItems(Arrays.asList(StateDto.getEmptyState()));
//    }
//    
//    public static void setOnlySelectLga(CustomListBox<LgaDto> listBox) {
//        listBox.setItems(Arrays.asList(LgaDto.getEmptyLga()));
//    }
//    
//    public static void setLgas(String stateId, final CustomListBox<LgaDto> listBox) {
//        listBox.removeAllItems();
//        listBox.addListItem(LgaDto.getEmptyLga());
//
//        AddressConfigMngrService.Util.getService().getLgaDtos(stateId,
//                new AsyncCallback<List<LgaDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting lgas.");
//            }
//
//            @Override
//            public void onSuccess(List<LgaDto> result) {
//                    listBox.addItems(result);
//            }
//
//        });
//    }
//
//    public static void setLgas(String stateId, 
//            final CustomListBox<LgaDto> listBox, final LgaDto lgaDto) {
//        listBox.removeAllItems();
//        listBox.addListItem(LgaDto.getEmptyLga());
//
//        //setLgas(stateId, listBox);
//        //listBox.setSelectedItem(lgaDto);
//        
//        AddressConfigMngrService.Util.getService().getLgaDtos(stateId,
//                new AsyncCallback<List<LgaDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting lgas.");
//            }
//
//            @Override
//            public void onSuccess(List<LgaDto> result) {
//                    listBox.addItems(result);
//                    listBox.setSelectedItem(lgaDto);
//            }
//
//        });
//    }
//
//    public static void setLgasWithEmptySelectOnly(final CustomListBox<LgaDto> 
//            listBox) {
//        listBox.removeAllItems();
//        listBox.addListItem(LgaDto.getEmptyLga());
//    }
//
//    public static void setStates(final CustomListBox<StateDto> listBox) {
//        listBox.removeAllItems();
//        listBox.addListItem(StateDto.getEmptyState());
//
//        //get from cache
//        if (CacheManager.getStates() != null) { //if already cached
//            listBox.addItems(CacheManager.getStates()); //NGN states
//            return;
//        }
//
//        AddressConfigMngrService.Util.getService().getStateDtos(
//                new AsyncCallback<List<StateDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting states.");
//            }
//
//            @Override
//            public void onSuccess(List<StateDto> result) {
//                //Window.alert(String.valueOf(result.size()));
//                listBox.addItems(result);
//            }
//        });
//    }
//
//    public static void setStates(final CustomListBox<StateDto> listBox,
//	     final StateDto selectedItem) {
//        listBox.removeAllItems();
//        listBox.addListItem(StateDto.getEmptyState());
//
//        setStates(listBox);
//        listBox.setSelectedItem(selectedItem);
//
//
//    }
//
//    public static void setCountries(final CustomListBox<CountryDto> listBox) {
//        listBox.removeAllItems();
//        listBox.addListItem(CountryDto.getEmptyCountry());
//
//        if (CacheManager.getCountries() != null) { //if already cached
//            listBox.addItems(CacheManager.getCountries());
//            return;
//        }
//
//        AddressConfigMngrService.Util.getService().getCountries(
//                new AsyncCallback<List<CountryDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting countries.");
//            }
//
//            @Override
//            public void onSuccess(List<CountryDto> result) {
//                listBox.addItems(result);
//                listBox.setSelectedItem(new CountryDto("NGN", "Nigeria"));
//            }
//        });
//    }
//
//    public static void setCountries(final CustomListBox<CountryDto> listBox,
//            final CountryDto selectedItem) {
//        //final CustomListBox<FacultyDto> facListBox = new CustomListBox<FacultyDto>();
//        listBox.removeAllItems();
//        listBox.addListItem(CountryDto.getEmptyCountry());
//
//        setCountries(listBox);
//        listBox.setSelectedItem(selectedItem);
//
//    }
//
//    
//    public static void setAllStaff(
//	    final CustomListBox<StaffLiteDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.addListItem(StaffLiteDto.getEmptyStaff());
//
//        StaffMngrService.Util.getInstance().getStaffLiteList(
//		new AsyncCallback<List<StaffLiteDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting staff");
//	    }
//
//	    @Override
//	    public void onSuccess(List<StaffLiteDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<StaffLiteDto>(result));
//	    }
//	});
//    }
//
//    public static void setSections(final CustomListBox<SectionDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SectionDto.getEmptySection());
//
//        SchoolConfigMngrService.Util.getService().getSections(
//                new AsyncCallback<List<SectionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SectionDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<SectionDto>(result));
//	    }
//        });
//    }
//        
//    public static void setSections(final CustomListBox<SectionDto> listBox, 
//            final WidgetReadyHandler wrh) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SectionDto.getEmptySection());
//
//        SchoolConfigMngrService.Util.getService().getSections(
//                new AsyncCallback<List<SectionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SectionDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<SectionDto>(result));
//                if (wrh != null)
//                    wrh.widgetReady();
//	    }
//        });
//    }
//    
//    public static void setSectionsWoEmptySelect(final CustomListBox<SectionDto> listBox, 
//            final WidgetReadyHandler wrh) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//
//        SchoolConfigMngrService.Util.getService().getSections(
//                new AsyncCallback<List<SectionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SectionDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<SectionDto>(result));
//                if (wrh != null)
//                    wrh.widgetReady();
//	    }
//        });
//    }
//    
//    public static void setSections(final CustomListBox<SectionDto> listBox,
//            final SectionDto sectionDto) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SectionDto.getEmptySection());
//
//        SchoolConfigMngrService.Util.getService().getSections(
//                new AsyncCallback<List<SectionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SectionDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<SectionDto>(result));
//                listBox.setSelectedItem(sectionDto);
//	    }
//        });
//    }
//    
//    public static void setSections(final CustomListBox<SectionDto> listBox,
//            final String sessionId, final String termId) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SectionDto.getEmptySection());
//
//        TermConfigMngrService.Util.getService().getTermSectionInfos(sessionId, 
//                termId, new AsyncCallback<List<TermSectionInfoDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermSectionInfoDto> result) {
//                LoadingWidget.INSTANCE.hide();
//                List<SectionDto> sections = new ArrayList<SectionDto>();
//                
//                for (TermSectionInfoDto t: result) {
//                    sections.add(t.getSection());
//                }
//                
//		listBox.addItems(sections);
//	    }
//        });
//    }
//
//    public static void setSections(final CustomListBox<SectionDto> listBox,
//            final String sessionId, final String termId, final SectionDto selSection) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SectionDto.getEmptySection());
//
//        TermConfigMngrService.Util.getService().getTermSectionInfos(
//                sessionId, termId, new AsyncCallback<List<TermSectionInfoDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermSectionInfoDto> result) {
//                LoadingWidget.INSTANCE.hide();
//                List<SectionDto> sections = new ArrayList<SectionDto>();
//                
//                for (TermSectionInfoDto t: result) {
//                    sections.add(t.getSection());
//                }
//                
//		listBox.addItems(sections);
//                listBox.setSelectedItem(selSection);
//	    }
//        });
//    }
//    
//    public static void setSubjectTypes(final CustomListBox<SubjectTypeDto> 
//            listBox) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SubjectTypeDto.getEmptySubjectType());
//
//        SubjectMngrService.Util.getService().getSubjectTypes(
//                new AsyncCallback<List<SubjectTypeDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SubjectTypeDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<SubjectTypeDto>(result));
//	    }
//        });
//        
//    }
//    
//    public static void setSubjectTypes(final CustomListBox<SubjectTypeDto> 
//            listBox, final SubjectTypeDto subjectTypeDto) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SubjectTypeDto.getEmptySubjectType());
//
//        SubjectMngrService.Util.getService().getSubjectTypes(
//                new AsyncCallback<List<SubjectTypeDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting sections");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SubjectTypeDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<SubjectTypeDto>(result));
//                listBox.setSelectedItem(subjectTypeDto);
//	    }
//        });
//        
//    }
//
//    public static void setStudentAttendedTerms(String studentId, 
//            final CustomListBox<TermDto> listBox, final TermDto selectedTerm, 
//            final WidgetReadyHandler wrh) {
//        
//        LoadingWidget.INSTANCE.show();   
//        
//        //clear
//        listBox.clear();
//        
//        StudentMngrService.Util.getService().getAttendedTerms(studentId, 
//                new AsyncCallback<List<TermDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting attended classes.");
//            }
//
//            @Override
//            public void onSuccess(List<TermDto> result) {
//                listBox.setItems(result);
//                
//                if (result.contains(selectedTerm))
//                    listBox.setSelectedItem(selectedTerm);
//                
//                LoadingWidget.INSTANCE.hide();
//                wrh.widgetReady();
//            }
//        });
//    }
//
//    public static void setTermsWithoutEmptySelect(
//            final CustomListBox<TermDto> listBox, final TermDto selectedTerm) {
//        
//        LoadingWidget.INSTANCE.show();
//        
//        TermConfigMngrService.Util.getService().getTerms(
//                new AsyncCallback<List<TermDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting terms");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TermDto>(result));
//                listBox.setSelectedItem(selectedTerm);
//	    }
//        });
//    }
//public static void setTermsWithoutEmptySelect(
//            final CustomListBox<TermDto> listBox, final TermDto selectedTerm, 
//            final WidgetReadyHandler wrh) {
//        
//        LoadingWidget.INSTANCE.show();
//        
//        TermConfigMngrService.Util.getService().getTerms(
//                new AsyncCallback<List<TermDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting terms");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TermDto>(result));
//                listBox.setSelectedItem(selectedTerm);
//                
//                if(wrh != null) {
//                    wrh.widgetReady();
//                }
//	    }
//        });
//    }
//    public static void setTermsWithoutEmptySelect(
//            final CustomListBox<TermDto> listBox) {
//        
//        LoadingWidget.INSTANCE.show();
//        
//        TermConfigMngrService.Util.getService().getTerms(
//                new AsyncCallback<List<TermDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting terms");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TermDto>(result));
//	    }
//        });
//    }
//    
//    public static void setTermsWithoutEmptySelect(
//            final CustomListBox<TermDto> listBox, final WidgetReadyHandler wrh) {
//        
//        LoadingWidget.INSTANCE.show();
//        
//        TermConfigMngrService.Util.getService().getTerms(
//                new AsyncCallback<List<TermDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting terms");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TermDto>(result));
//                wrh.widgetReady();
//	    }
//        });
//    }
//    
//    public static void setSubjects(final CustomListBox<SubjectDto> listBox) {        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SubjectDto.getEmptySubject());
//        
//        SubjectMngrService.Util.getService().getSubjects(
//                new AsyncCallback<List<SubjectDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting terms");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SubjectDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<SubjectDto>(result));
//	    }
//        });
//    }
//    
//    public static void setAssessmentFormats(final CustomListBox<AssessmentFormatDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(AssessmentFormatDto.getEmptyAssessmentFormat());
//
//        AssessmentConfigMngrService.Util.getService().getAssessmentFormats(
//                new AsyncCallback<List<AssessmentFormatDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting assessment formats");
//	    }
//
//	    @Override
//	    public void onSuccess(List<AssessmentFormatDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<AssessmentFormatDto>(result));
//	    }
//        });
//    }
//    
//    public static void setAssessmentFormats(final CustomListBox<AssessmentFormatDto> listBox,
//            final AssessmentFormatDto assessmentFormatDto) {
//
//       LoadingWidget.INSTANCE.show();
//       listBox.removeAllItems();
//       listBox.addListItem(AssessmentFormatDto.getEmptyAssessmentFormat());
//
//        AssessmentConfigMngrService.Util.getService().getAssessmentFormats(
//                new AsyncCallback<List<AssessmentFormatDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting assessment formats");
//	    }
//
//	    @Override
//	    public void onSuccess(List<AssessmentFormatDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<AssessmentFormatDto>(result));
//                listBox.setSelectedItem(assessmentFormatDto);
//	    }
//        });
//    }
//    
//    public static void setGradeFormats(final CustomListBox<GradeFormatDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(GradeFormatDto.getEmptyGradeFormat());
//
//        GradeConfigMngrService.Util.getService().getGradeFormats(
//                new AsyncCallback<List<GradeFormatDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting grade formats");
//	    }
//
//	    @Override
//	    public void onSuccess(List<GradeFormatDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<GradeFormatDto>(result));
//	    }
//        });
//    }
//    
//    public static void setGradeFormats(final CustomListBox<GradeFormatDto> listBox,
//            final GradeFormatDto gradeFormatDto) {
//
//       LoadingWidget.INSTANCE.show();
//       listBox.removeAllItems();
//       listBox.addListItem(GradeFormatDto.getEmptyGradeFormat());
//
//        GradeConfigMngrService.Util.getService().getGradeFormats(
//                new AsyncCallback<List<GradeFormatDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting grade formats");
//	    }
//
//	    @Override
//	    public void onSuccess(List<GradeFormatDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<GradeFormatDto>(result));
//                listBox.setSelectedItem(gradeFormatDto);
//	    }
//        });
//    }
//    
//    public static void setPromotionCriteria(final CustomListBox<PromotionCriteriaDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(PromotionCriteriaDto.getEmptyPromotionCriteria());
//
//        PromotionCriteriaConfigMngrService.Util.getService().getPromotionCriteria(
//                new AsyncCallback<List<PromotionCriteriaDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting promotion criteria");
//	    }
//
//	    @Override
//	    public void onSuccess(List<PromotionCriteriaDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<PromotionCriteriaDto>(result));
//	    }
//        });
//    }
//    
//    public static void setPromotionCriteria(final CustomListBox<PromotionCriteriaDto> listBox,
//            final PromotionCriteriaDto promotionCriteriaDto) {
//
//       LoadingWidget.INSTANCE.show();
//       listBox.removeAllItems();
//       listBox.addListItem(PromotionCriteriaDto.getEmptyPromotionCriteria());
//
//        PromotionCriteriaConfigMngrService.Util.getService().getPromotionCriteria(
//                new AsyncCallback<List<PromotionCriteriaDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting promotion criteria");
//	    }
//
//	    @Override
//	    public void onSuccess(List<PromotionCriteriaDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<PromotionCriteriaDto>(result));
//                listBox.setSelectedItem(promotionCriteriaDto);
//	    }
//        });
//    }
//    
//    public static void setTraits(final CustomListBox<TraitDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(TraitDto.getEmptyTrait());
//
//        TraitConfigMngrService.Util.getService().getTraits(
//                new AsyncCallback<List<TraitDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting trait");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TraitDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TraitDto>(result));
//	    }
//        });
//    }
//    
//    public static void setTraits(final CustomListBox<TraitDto> listBox,
//            final TraitDto traitDto) {
//
//       LoadingWidget.INSTANCE.show();
//       listBox.removeAllItems();
//       listBox.addListItem(TraitDto.getEmptyTrait());
//
//        TraitConfigMngrService.Util.getService().getTraits(
//                new AsyncCallback<List<TraitDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting traits");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TraitDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TraitDto>(result));
//                listBox.setSelectedItem(traitDto);
//	    }
//        });
//    }
//    
//    public static void setTraitRatings(final CustomListBox<TraitRatingDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(TraitRatingDto.getEmptyTraitRating());
//
//        TraitConfigMngrService.Util.getService().getTraitRatings(
//                new AsyncCallback<List<TraitRatingDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting trait rating");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TraitRatingDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TraitRatingDto>(result));
//	    }
//        });
//    }
//    
//    public static void setTraitRatings(final CustomListBox<TraitRatingDto> listBox,
//            final TraitRatingDto traitRatingDto) {
//
//       LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(TraitRatingDto.getEmptyTraitRating());
//
//        TraitConfigMngrService.Util.getService().getTraitRatings(
//                new AsyncCallback<List<TraitRatingDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting trait rating");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TraitRatingDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TraitRatingDto>(result));
//                listBox.setSelectedItem(traitRatingDto);
//	    }
//        });
//    }
//
//
//    public static void setStudentAttendedSessions(String studentId, 
//            final CustomListBox<SessionDto> listBox, final SessionDto selectedSession, 
//            final WidgetReadyHandler wrh) {
//        
//        LoadingWidget.INSTANCE.show();   
//        
//        //clear
//        listBox.clear();
//        
//        StudentMngrService.Util.getService().getAttendedSessions(studentId, 
//                new AsyncCallback<List<SessionDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting attended classes.");
//            }
//
//            @Override
//            public void onSuccess(List<SessionDto> result) {
//                listBox.setItems(result);
//                
//                if (result.contains(selectedSession))
//                    listBox.setSelectedItem(selectedSession);
//                
//                LoadingWidget.INSTANCE.hide();
//                wrh.widgetReady();
//            }
//        });
//    }
//
//    public static void setTermsAsSubjectTeacher(final String staffId, 
//            final CustomListBox<TermDto> listBox, final TermDto selectedTerm, 
//            final WidgetReadyHandler wrh) {
//               
//        LoadingWidget.INSTANCE.show();   
//        
//        //clear
//        listBox.clear();
//        
//        SubjectTeachersMngrService.Util.getService().getTermsAsSubjectTeacher(
//                staffId, new AsyncCallback<List<TermDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting terms");
//            }
//
//            @Override
//            public void onSuccess(List<TermDto> result) {
//                listBox.setItems(result);
//                
//                if (result.contains(selectedTerm))
//                    listBox.setSelectedItem(selectedTerm);
//                
//                wrh.widgetReady();
//                
//                LoadingWidget.INSTANCE.hide();
//            }
//        });       
//    }
//
//    public static void setTermsAsFormTeacher(final String staffId, 
//            final CustomListBox<TermDto> listBox, final TermDto selectedTerm, 
//            final WidgetReadyHandler wrh) {
//               
//        LoadingWidget.INSTANCE.show();   
//        
//        //clear
//        listBox.clear();
//        
//        ClassFunctionsMngrService.Util.getService().getTermsAsFormTeacher(
//                staffId, new AsyncCallback<List<TermDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting terms");
//            }
//
//            @Override
//            public void onSuccess(List<TermDto> result) {
//                listBox.setItems(result);
//                
//                if (result.contains(selectedTerm))
//                    listBox.setSelectedItem(selectedTerm);
//                
//                wrh.widgetReady();
//                
//                LoadingWidget.INSTANCE.hide();
//            }
//        });       
//    }
//    
//    public static void setAssessmentList(final CustomListBox<AssessmentDto> 
//            listBox, final String sessionId, final String termId, 
//            final String sectionId, final WidgetReadyHandler wrh) {
//                
//        LoadingWidget.INSTANCE.show();   
//        
//        //clear
//        listBox.clear();
//        listBox.addListItem(AssessmentDto.getEmptyAssessment());
//        
//        CognitiveAssessmentMngrService.Util.getService().getAssessments(
//                sessionId, termId, sectionId, 
//                new AsyncCallback<List<AssessmentDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, "Error "
//                        + "getting assessments.");
//            }
//
//            @Override
//            public void onSuccess(List<AssessmentDto> result) {
//                listBox.setItems(result);
//                
//                wrh.widgetReady();                
//                LoadingWidget.INSTANCE.hide();
//            }
//        });
//    }
//
//    public static void setAssessmentListWoEmptySelect(final CustomListBox<AssessmentDto> 
//            listBox, final String sessionId, final String termId, 
//            final String sectionId, final WidgetReadyHandler wrh) {
//                
//        LoadingWidget.INSTANCE.show();   
//        
//        //clear
//        listBox.clear();
//        
//        CognitiveAssessmentMngrService.Util.getService().getAssessments(
//                sessionId, termId, sectionId, 
//                new AsyncCallback<List<AssessmentDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, "Error "
//                        + "getting assessments.");
//            }
//
//            @Override
//            public void onSuccess(List<AssessmentDto> result) {
//                listBox.setItems(result);
//                
//                wrh.widgetReady();                
//                LoadingWidget.INSTANCE.hide();
//            }
//        });
//    }
//
//    public static void setEmptyAssessmentList(final CustomListBox<AssessmentDto> 
//            listBox) {
//                
//        //clear
//        listBox.clear();
//        listBox.addListItem(AssessmentDto.getEmptyAssessment());
//    }
//    
//    public static void setSectionTraitFormats(final String sessionId, 
//            final String termId, final String sectionId, 
//            final CustomListBox<SectionTraitFormatDto> listBox) {
//
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SectionTraitFormatDto.getEmptySectionTraitFormat());
//
//        TermSectionFormatsConfigMngrService.Util.getService()
//                .getSectionTraitFormats(sessionId, termId, sectionId,
//                new AsyncCallback<List<SectionTraitFormatDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting trait formats");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SectionTraitFormatDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(result);
//	    }
//        });        
//    }
//
//    public static void setGradeWithEmptySelectOnly(CustomListBox<GradeDto> listBox) {
//	listBox.setItems(Arrays.asList(GradeDto.getEmptyGrade()));
//    }
//
//    public static void setSubjects(final CustomListBox<SubjectDto> listBox, 
//            final SubjectDto subject) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SubjectDto.getEmptySubject());
//        
//        SubjectMngrService.Util.getService().getSubjects(
//                new AsyncCallback<List<SubjectDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting subjects");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SubjectDto> result) {
//		listBox.addItems(new ArrayList<SubjectDto>(result));
//                listBox.setSelectedItem(subject);
//                
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//
//    public static void setSubjects(final CustomListBox<SubjectDto> listBox, 
//            final SectionDto section) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SubjectDto.getEmptySubject());
//        
//        SubjectMngrService.Util.getService().getSubjectsInSection(section.getSectionId(), 
//                new AsyncCallback<List<SubjectDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting subjects");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SubjectDto> result) {
//		listBox.addItems(new ArrayList<SubjectDto>(result));
//                
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//    
//    public static void setGrades(final String gradeFormatId, 
//            final CustomListBox<GradeDto> listBox) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(GradeDto.getEmptyGrade());
//        
//        GradeConfigMngrService.Util.getService().getGrades(gradeFormatId, 
//                new AsyncCallback<List<GradeDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting subjects");
//	    }
//
//	    @Override
//	    public void onSuccess(List<GradeDto> result) {
//		listBox.addItems(result);                
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//
//    public static void setGrades(final String gradeFormatId, 
//            final CustomListBox<GradeDto> listBox, final GradeDto selectedGrade) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(GradeDto.getEmptyGrade());
//        
//        GradeConfigMngrService.Util.getService().getGrades(gradeFormatId, 
//                new AsyncCallback<List<GradeDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting subjects");
//	    }
//
//	    @Override
//	    public void onSuccess(List<GradeDto> result) {
//		listBox.addItems(result);         
//                listBox.setSelectedItem(selectedGrade);
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//    
//    public static void setReligions(final CustomListBox<String> listBox) {
//        listBox.removeAllItems();
//	listBox.addListItem("- Select Religion -");
//        listBox.addListItem("Christianity");
//        listBox.addListItem("Islam");
//        listBox.addListItem("Other");
//    }
//
//    public static void setReligions(final CustomListBox<String> listBox,
//	    String religion) {
//        listBox.removeAllItems();
//	listBox.addListItem("- Select Religion -");
//        listBox.addListItem("Christianity");
//        listBox.addListItem("Islam");
//        listBox.addListItem("Other");
//
//	listBox.setSelectedItem(religion);
//    }
//    
//    public static void setTitles(final CustomListBox<String> listBox) {
//        listBox.removeAllItems();
//	listBox.addListItem("- Select Title -");
//        listBox.addListItem("Mr.");
//        listBox.addListItem("Mrs.");
//        listBox.addListItem("Miss");
//        listBox.addListItem("Dr.");
//        listBox.addListItem("Prof.");
//        listBox.addListItem("Alh.");
//        listBox.addListItem("Malam");
//        listBox.addListItem("Hajia");
//    }
//
//    public static void setTitles(final CustomListBox<String> listBox,
//	    String religion) {
//        listBox.removeAllItems();
//	listBox.addListItem("- Select Title -");
//        listBox.addListItem("Mr.");
//        listBox.addListItem("Mrs.");
//        listBox.addListItem("Miss");
//        listBox.addListItem("Dr.");
//        listBox.addListItem("Prof.");
//        listBox.addListItem("Alh.");
//        listBox.addListItem("Malam");
//        listBox.addListItem("Hajia");
//        listBox.addListItem("Malama");
//
//	listBox.setSelectedItem(religion);
//    }
//
//
//    public static void setTermDefinitions(final CustomListBox<TermDefinitionDto> 
//            listBox) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(TermDefinitionDto.getEmptyTermDefinition());
//        
//        TermConfigMngrService.Util.getService().getTermDefinitions( 
//                new AsyncCallback<List<TermDefinitionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting term definitions");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDefinitionDto> result) {
//		listBox.addItems(result);         
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//
//    public static void setTermDefinitionsWoEmptySelect(
//            final CustomListBox<TermDefinitionDto> listBox) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        
//        TermConfigMngrService.Util.getService().getTermDefinitions( 
//                new AsyncCallback<List<TermDefinitionDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting term definitions");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDefinitionDto> result) {
//		listBox.addItems(result);         
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//    
//    public static void setArms(final CustomListBox<ArmDto> listBox) {
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(ArmDto.getEmptyArm());
//        
//        SchoolConfigMngrService.Util.getService().getArms( 
//                new AsyncCallback<List<ArmDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting arms");
//	    }
//
//	    @Override
//	    public void onSuccess(List<ArmDto> result) {
//		listBox.addItems(result);         
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });        
//    }
//    
//    public static void setKlasses(final CustomListBox<KlassDto> listBox) {
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(KlassDto.getEmptyKlass());
//        
//        SchoolConfigMngrService.Util.getService().getClasses( 
//                new AsyncCallback<List<KlassDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting classes");
//	    }
//
//	    @Override
//	    public void onSuccess(List<KlassDto> result) {
//		listBox.addItems(result);         
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });        
//    }
//    
//    public static void setKlasses(final CustomListBox<ClassInfoDto> listBox, 
//            String sessionId, String termId, String sectionId) {
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        
//        ClassInfoDto klass = new ClassInfoDto(TermDto.getEmptyTerm(), 
//                KlassDto.getEmptyKlass(), ArmDto.getEmptyArm());
//        listBox.addListItem(klass);
//        
//        
//        ClassFunctionsMngrService.Util.getService().getClasses(sessionId, 
//            termId, sectionId, new AsyncCallback<List<ClassInfoDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting classes");
//            }
//
//            @Override
//            public void onSuccess(List<ClassInfoDto> result) {
//                listBox.addItems(result);         
//                LoadingWidget.INSTANCE.hide();
//            }
//        });
//    }
//
//    public static void setKlassesWithEmptySelectOnly(
//            final CustomListBox<ClassInfoDto> listBox) {
//        
//        listBox.removeAllItems();
//        listBox.addListItem(ClassInfoDto.getEmptyClassInfo());
//    }
//
//    public static void setAssessmentTypeWoEmptySelectList(
//            final CustomListBox<AssessmentTypeDto> listBox, 
//            final AssessmentTypeDto assessmentType) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        
//        AssessmentConfigMngrService.Util.getService().getAssessmentTypes( 
//                new AsyncCallback<List<AssessmentTypeDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting assessment types");
//	    }
//
//	    @Override
//	    public void onSuccess(List<AssessmentTypeDto> result) {
//		listBox.addItems(result);         
//                listBox.setSelectedItem(assessmentType);
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });  
//    }
//
//    public static void setRelationships(final CustomListBox<RelationshipDto> 
//            listBox) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(RelationshipDto.getEmptyRelationship());
//        
//        GuardianMngrService.Util.getService().getRelationships( 
//                new AsyncCallback<List<RelationshipDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting classes");
//	    }
//
//	    @Override
//	    public void onSuccess(List<RelationshipDto> result) {
//		listBox.addItems(result);         
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//
//    public static void setSchoolHouses(final CustomListBox<SchoolHouseDto> 
//            listBox) {
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        listBox.addListItem(SchoolHouseDto.getEmptySchoolHouse());
//        
//        SchoolHouseMngrService.Util.getService().getSchoolHouses( 
//                new AsyncCallback<List<SchoolHouseDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting school houses");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SchoolHouseDto> result) {
//		listBox.addItems(result);         
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//
//    public static void setSchoolHousesAssigned(final TermDto term, String staffId, 
//            final CustomListBox<SchoolHouseDto> listBox, 
//            final WidgetReadyHandler wrh) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        
//        SchoolHouseMngrService.Util.getService().getSchoolHousesAssigned(term, 
//                staffId, new AsyncCallback<List<SchoolHouseDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting school houses assigned");
//	    }
//
//	    @Override
//	    public void onSuccess(List<SchoolHouseDto> result) {
//		listBox.addItems(result);
//                if (wrh != null) {
//                    wrh.widgetReady();
//                }
//                
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });
//    }
//
//    public static void setKlasses(final CustomListBox<ClassInfoDto> listBox, 
//            TermDto term, String staffId, 
//            final WidgetReadyHandler widgetReadyHandler) {
//        
//        LoadingWidget.INSTANCE.show();
//        listBox.removeAllItems();
//        
//        ClassFunctionsMngrService.Util.getService().getClassesAssigned( 
//                term, staffId, new AsyncCallback<List<ClassInfoDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting classes");
//	    }
//
//	    @Override
//	    public void onSuccess(List<ClassInfoDto> result) {                
//		listBox.setItems(result);      
//                if (widgetReadyHandler != null)
//                    widgetReadyHandler.widgetReady();
//                
//                LoadingWidget.INSTANCE.hide();
//	    }
//        });      
//    }
//
//    public static void setTermWithoutEmptySelectAndGivenTerm(
//            final CustomListBox<TermDto> listBox, final TermDto termDto) {
//        
//        LoadingWidget.INSTANCE.show();
//        
//        TermConfigMngrService.Util.getService().getTerms(
//                new AsyncCallback<List<TermDto>>() {
//
//	    @Override
//	    public void onFailure(Throwable caught) {
//		ErrorHandler.handleError(caught, WidgetsFactory.class,
//			"Error getting terms");
//	    }
//
//	    @Override
//	    public void onSuccess(List<TermDto> result) {
//                LoadingWidget.INSTANCE.hide();
//		listBox.addItems(new ArrayList<TermDto>(result));
//                listBox.removeItem(termDto);
//                
//                if (result.size()-1 > 0)
//                    listBox.setSelectedIndex(result.size() - 2);
//	    }
//        });
//    }
//
//    public static void setExamTypes(final CustomListBox<ExamTypeDto> list) {
//        list.removeAllItems(); // clear list first
//        list.addListItem(ExamTypeDto.getEmtyExamType());// initial
//        
//        // get from server
//        ExternalResultMngrService.Util.getService().getAllexamtypes(
//                new AsyncCallback<List<ExamTypeDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error getting Exam Types");
//            }
//
//            @Override
//            public void onSuccess(List<ExamTypeDto> results) {
//                list.addItems(results);
//            }
//        });
//        
//    }
//    
//    public static void setExamTypes(final CustomListBox<ExamTypeDto> list,
//            final ExamTypeDto examType) {
//        list.removeAllItems(); // clear list first
//        list.addListItem(ExamTypeDto.getEmtyExamType());// initial
//        
//        // get from server
//        ExternalResultMngrService.Util.getService().getAllexamtypes(
//                new AsyncCallback<List<ExamTypeDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error getting Exam Types");
//            }
//
//            @Override
//            public void onSuccess(List<ExamTypeDto> results) {
//                list.addItems(results);
//                list.setSelectedItem(examType);
//            }
//        });
//        
//    }
//    public static void setSchoolFeesItems(final CustomListBox<SchoolFeesItemDto> list){
//        list.removeAllItems();
//        list.addListItem(SchoolFeesItemDto.getEmtySchoolFeesItem());
//        // get from Db
//        SchoolFeesMngrService.Util.getService().getAllItems(
//                new AsyncCallback<List<SchoolFeesItemDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, 
//                        "Error fetching school fees items list");
//            }
//
//            @Override
//            public void onSuccess(List<SchoolFeesItemDto> result) {
//               for (SchoolFeesItemDto sfi : result){
//                   list.addListItem(sfi);
//               }
//            }
//        });
//    }
//    public static void setSchoolFeesItems(final CustomListBox<SchoolFeesItemDto> list, 
//            final SchoolFeesItemDto item){
//        list.removeAllItems();
//        list.addListItem(SchoolFeesItemDto.getEmtySchoolFeesItem());
//        // get from Db
//        SchoolFeesMngrService.Util.getService().getAllItems(
//                new AsyncCallback<List<SchoolFeesItemDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, 
//                        "Error fetching school fees items list");
//            }
//
//            @Override
//            public void onSuccess(List<SchoolFeesItemDto> result) {
//               for (SchoolFeesItemDto sfi : result){
//                   list.addListItem(sfi);
//               }
//               list.setSelectedItem(item);
//            }
//        });
//    }
// 	public static void setBoardingDayPolicy(CustomListBox<String> listBox) {
//        
//        listBox.addListItem("- Select Type -");
//        listBox.addListItem("DAY");
//        listBox.addListItem("DAY BOARDING");
//        listBox.addListItem("BOARDING");
//    }
//        
//    public static void setPayrollConfigs(final CustomListBox<PayrollConfigDto> listBox) {
//        listBox.removeAllItems();
//        listBox.addListItem(PayrollConfigDto.getEmptyPayrollConfig());
//
//        PayrollMngrService.Util.getService().getPayrollConfigs(new 
//                AsyncCallback<List<PayrollConfigDto>>() {
//
//            @Override
//            public void onFailure(Throwable thrwbl) {
//                ErrorHandler.handleError(thrwbl, "Error getting payroll configurations"); 
//            }
//
//            @Override
//            public void onSuccess(List<PayrollConfigDto> t) {
//                for (PayrollConfigDto configDto : t){
//                   listBox.addListItem(configDto);
//                }
//            }
//        });
//    }
//
//    public static void setPayrollConfigs(final CustomListBox<PayrollConfigDto> 
//            listBox, final PayrollConfigDto selectedItem) {
//
//        listBox.removeAllItems();
//        listBox.addListItem(PayrollConfigDto.getEmptyPayrollConfig());
//
//        PayrollMngrService.Util.getService().getPayrollConfigs(new 
//                AsyncCallback<List<PayrollConfigDto>>() {
//
//            @Override
//            public void onFailure(Throwable thrwbl) {
//                ErrorHandler.handleError(thrwbl, "Error getting payroll configurations"); 
//            }
//
//            @Override
//            public void onSuccess(List<PayrollConfigDto> t) {
//                for (PayrollConfigDto configDto : t){
//                   listBox.addListItem(configDto);
//                }
//                
//                listBox.setSelectedItem(selectedItem);
//            }
//        });        
//    }
//
//    public static void setSubheads(final CustomListBox<SubheadDto> subheadList) {
//        subheadList.removeAllItems();
//        subheadList.addListItem(SubheadDto.getEmptySubhead());
//        
//        ExpensesMngrService.Util.getService().getSubheads(new AsyncCallback<List<SubheadDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error loading Subheads");
//            }
//
//            @Override
//            public void onSuccess(List<SubheadDto> result) {
//                for (SubheadDto dto : result) {
//                    subheadList.addListItem(dto);
//                }
//            }
//        });
//    }
//
//    public static void setSubhead(final CustomListBox<SubheadDto> subheadList,
//            final SubheadDto subheadDto) {
//        subheadList.removeAllItems();
//        subheadList.addListItem(SubheadDto.getEmptySubhead());
//        
//        ExpensesMngrService.Util.getService().getSubheads(new AsyncCallback<List<SubheadDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error loading Subheads");
//            }
//
//            @Override
//            public void onSuccess(List<SubheadDto> result) {
//                for (SubheadDto dto : result) {
//                    subheadList.addListItem(dto);
//                }
//                
//                subheadList.setSelectedItem(subheadDto);
//            }
//        });
//    }
//
//    public static void setExpenseItems(final CustomListBox<ExpenseItemDto> expenseItemList) {
//        expenseItemList.removeAllItems();
//        expenseItemList.addListItem(ExpenseItemDto.getEmptyItems());
//        
//        ExpensesMngrService.Util.getService().getExpenseItems(new AsyncCallback<List<ExpenseItemDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error loading Subheads");
//            }
//
//            @Override
//            public void onSuccess(List<ExpenseItemDto> result) {
//                for (ExpenseItemDto dto : result) {
//                    expenseItemList.addListItem(dto);
//                }
//            }
//        });
//    }
//
//    public static void setExpenseItem(final CustomListBox<ExpenseItemDto> expenseItemList, 
//            final ExpenseItemDto expenseItemDto) {
//        
//        expenseItemList.removeAllItems();
//        expenseItemList.addListItem(ExpenseItemDto.getEmptyItems());
//        
//        ExpensesMngrService.Util.getService().getExpenseItems(new AsyncCallback<List<ExpenseItemDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error loading Subheads");
//            }
//
//            @Override
//            public void onSuccess(List<ExpenseItemDto> result) {
//                for (ExpenseItemDto dto : result) {
//                    expenseItemList.addListItem(dto);
//                }
//                
//                expenseItemList.setSelectedItem(expenseItemDto);
//            }
//        });
//    }
//
//    public static void setYears(CustomListBox<Integer> yearList, int startYear, 
//            int maxYear, int selectedYear) {
//        
//        for (int i = startYear; i <= maxYear; i++) {
//            yearList.addListItem(i);
//        }
//        yearList.setSelectedItem(selectedYear + 1900);
//    }
//
//    public static void setMonths(CustomListBox<MonthType> monthList, int month) {        
//        monthList.addItems(Arrays.asList(MonthType.values()));
//        monthList.setSelectedItem(MonthType.values()[month]);
//    }
//
//    public static void setManualRemunerationItems(
//            final CustomListBox<ManualRemunerationItemDto> remunerationItemList) {
//        remunerationItemList.removeAllItems();
//        remunerationItemList.addListItem(ManualRemunerationItemDto
//                .getEmptyRemunerationItem());
//        
//        PayrollMngrService.Util.getService().getManualRemunerationItems(
//                new AsyncCallback<List<ManualRemunerationItemDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting manual remuneration items");
//            }
//
//            @Override
//            public void onSuccess(List<ManualRemunerationItemDto> result) {
//                remunerationItemList.addItems(result);
//            }
//        });
//    }
//    
//    public static void setManualRemunerationItems(
//            final CustomListBox<ManualRemunerationItemDto> remunerationItemList,
//            final ManualRemunerationItemDto selectedItem) {
//        
//        remunerationItemList.removeAllItems();
//        remunerationItemList.addListItem(ManualRemunerationItemDto
//                .getEmptyRemunerationItem());
//        
//        PayrollMngrService.Util.getService().getManualRemunerationItems(
//                new AsyncCallback<List<ManualRemunerationItemDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, WidgetsFactory.class, 
//                        "Error getting manual remuneration items");
//            }
//
//            @Override
//            public void onSuccess(List<ManualRemunerationItemDto> result) {
//                remunerationItemList.addItems(result);
//                remunerationItemList.setSelectedItem(selectedItem);
//            }
//        });
//    }
//
//    public static void setBanks(final CustomListBox<BankDto> bankList) {
//        bankList.removeAllItems();
//        bankList.addListItem(BankDto.getEmptyBankDto());
//        
//        PayrollMngrService.Util.getService().getBankDtos(new AsyncCallback<List<BankDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error Fetching Bank List");
//            }
//
//            @Override
//            public void onSuccess(List<BankDto> result) {
//                bankList.addItems(result);
//            }
//        });
//    }
//
//    public static void setBanks(final CustomListBox<BankDto> bankList, final BankDto bank) {
//        bankList.removeAllItems();
//        bankList.addListItem(BankDto.getEmptyBankDto());
//        
//        PayrollMngrService.Util.getService().getBankDtos(new AsyncCallback<List<BankDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error getting banks");
//            }
//
//            @Override
//            public void onSuccess(List<BankDto> result) {
//                bankList.addItems(result);
//                bankList.setSelectedItem(bank);
//            }
//            
//            
//        });
//    }
//
//    public static void setTermDefinition(final CustomListBox<TermDefinitionDto> termList, 
//            final TermDefinitionDto termDefinition) {
//        termList.removeAllItems();
//        termList.addListItem(TermDefinitionDto.getEmptyTermDefinition());
//        
//        TermConfigMngrService.Util.getService().getTermDefinitions(
//                new AsyncCallback<List<TermDefinitionDto>>() {
//
//            @Override
//            public void onFailure(Throwable caught) {
//                ErrorHandler.handleError(caught, "Error getting TermDefinitions");
//            }
//
//            @Override
//            public void onSuccess(List<TermDefinitionDto> result) {
//                termList.addItems(result);
//                termList.setSelectedItem(termDefinition);
//            }
//        });
//    }
    
    public static void setProducts(final CustomListBox<ProductDto> listBox){
        listBox.removeAllItems();
        listBox.addListItem(ProductDto.getEmptySection());
        
        ProductMngrService.Util.getInstance().getProducts(new AsyncCallback<List<ProductDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error getting Products");
            }

            @Override
            public void onSuccess(List<ProductDto> result) {
                listBox.addItems(result);
            }
        });
    }
    
    public static void setProducts(final CustomListBox<ProductDto> productListBox,
            final ProductDto productDto){
        productListBox.removeAllItems();
        productListBox.addListItem(ProductDto.getEmptySection());
        
        ProductMngrService.Util.getInstance().getProducts(new AsyncCallback<List<ProductDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error getting Products");
            }

            @Override
            public void onSuccess(List<ProductDto> result) {
                productListBox.addItems(result);
                productListBox.setSelectedItem(productDto);
            }
        });
    }
    public static void setSections(final CustomListBox<FarmSectionDto> listBox) {
        listBox.removeAllItems();
        listBox.addListItem(FarmSectionDto.getEmptySection());
        
        FpmsConfigMngrService.Util.getInstance().getSections(new AsyncCallback<List<FarmSectionDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error getting sections");
            }

            @Override
            public void onSuccess(List<FarmSectionDto> result) {
                listBox.addItems(result);
            }

           
        });
    }

    public static void setSections(final CustomListBox<FarmSectionDto> sectionListBox,
            final FarmSectionDto sectionDto) {
       sectionListBox.removeAllItems();
       sectionListBox.addListItem(FarmSectionDto.getEmptySection());
       
       FpmsConfigMngrService.Util.getInstance().getSections(
               new AsyncCallback<List<FarmSectionDto>>() {

           @Override
           public void onFailure(Throwable caught) {
               Window.alert("Error getting sections");
           }

           @Override
           public void onSuccess(List<FarmSectionDto> result) {
               sectionListBox.addItems(result);
               sectionListBox.setSelectedItem(sectionDto);
           }
       });
    }
    
    public static void setExpenseTypes(final CustomListBox<ExpenseTypeDto> listBox){
        
        listBox.removeAllItems();
        listBox.addListItem(ExpenseTypeDto.getEmptyExpenseType());
        
        FpmsConfigMngrService.Util.getInstance().getExpenseTypes(new AsyncCallback<List<ExpenseTypeDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error geting Expense Types");
            }

            @Override
            public void onSuccess(List<ExpenseTypeDto> result) {
                listBox.addItems(result);
            }
        });
    }
    
    public static void setExpenseTypes(final CustomListBox<ExpenseTypeDto> typeListBox,
            final ExpenseTypeDto expenseTypeDto){
        typeListBox.removeAllItems();
        typeListBox.addListItem(ExpenseTypeDto.getEmptyExpenseType());
        
        FpmsConfigMngrService.Util.getInstance().getExpenseTypes(new AsyncCallback<List<ExpenseTypeDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error getting Expense Types");
            }

            @Override
            public void onSuccess(List<ExpenseTypeDto> result) {
                typeListBox.addItems(result);
                typeListBox.setSelectedItem(expenseTypeDto);
            }
        });
    }
}
